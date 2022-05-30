package com.dizertation.controller;

import com.dizertation.database.model.Station;
import com.dizertation.database.repository.StationRepository;
import com.dizertation.model.route.Route;
import com.dizertation.service.StationParsingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RouteController {
    private static final String E2_ROUTES_URL =
            "https://rt.api.opentransport.ro/api/v1/key/f78a2e9a/agency/ro.stpt/command/routesDetails?r=E2&format=json";

    @Autowired
    private StationParsingService parsingService;

    @Autowired
    private StationRepository repository;

    @GetMapping(path = "routes")
    public List<Route> getRoutesForE2() {
        return parsingService.parseRoute(E2_ROUTES_URL);
    }

    @PostMapping("/addRoute")
    public List<Route> saveRoute(@RequestBody Station station) {
        List<Route> routeList = getRoutesForE2();

        int stationSize = routeList.get(0).getDirection().get(0).getStations().size();

        for (int i = 0; i< stationSize; i++) {
            station.setId(routeList.get(0).getDirection().get(0).getStations().get(i).getId());
            station.setName(routeList.get(0).getDirection().get(0).getStations().get(i).getName());
            station.setLatitude(routeList.get(0).getDirection().get(0).getStations().get(i).getLat());
            station.setLongitude(routeList.get(0).getDirection().get(0).getStations().get(i).getLon());

            repository.save(station);
        }
        return routeList;
    }
}
