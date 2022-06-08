package com.dizertation.controller;

import com.dizertation.database.model.Station;
import com.dizertation.database.repository.StationRepository;
import com.dizertation.model.route.Route;
import com.dizertation.service.StationParsingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RouteController {

    @Autowired
    private StationParsingService parsingService;

    @Autowired
    private StationRepository repository;

    @GetMapping(path = "routes")
    public List<Route> getRoutesForE2(String routeShortName) {
        String url = String.format("https://rt.api.opentransport.ro/api/v1/key/f78a2e9a/agency/ro.stpt/command/routesDetails?r=%s&format=json", routeShortName);
        return parsingService.parseRoute(url);
    }

    @PostMapping("/addRoute/{routeShortName}")
    public List<Station> saveRoute(@PathVariable String routeShortName) {
        List<Route> routeList = getRoutesForE2(routeShortName);

        int stationSize = routeList.get(0).getDirection().get(0).getStations().size();

        List<Station> stationsList = new ArrayList<>();

        for (int i = 0; i< stationSize; i++) {
            Station station = new Station();

            station.setId(routeList.get(0).getDirection().get(0).getStations().get(i).getId());
            station.setName(routeList.get(0).getDirection().get(0).getStations().get(i).getName());
            station.setLatitude(routeList.get(0).getDirection().get(0).getStations().get(i).getLat());
            station.setLongitude(routeList.get(0).getDirection().get(0).getStations().get(i).getLon());

            stationsList.add(station);
            repository.save(station);
        }
        return stationsList;
    }
}
