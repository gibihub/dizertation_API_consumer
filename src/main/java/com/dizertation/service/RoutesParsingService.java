package com.dizertation.service;

import com.dizertation.model.route.Direction;
import com.dizertation.model.route.Extent;
import com.dizertation.model.route.Route;
import com.dizertation.model.route.Station;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class RoutesParsingService implements StationParsingService{
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public List<Route> parseRoute(String url) {
        List<Object> routes = (List<Object>) restTemplate.getForObject(url, Map.class).get("routes");
        List<Route> routeList = new ArrayList<>();

        for(Object obj : routes) {
            Map<String, Object> map = (Map<String, Object>) obj;

            Map<String, Object> extentMap = (Map<String, Object>) map.get("extent");
            List<Map<String, Object>> directionMap = (List<Map<String, Object>>) map.get("direction");

            Direction directionIdZero = new Direction();
            directionIdZero.setId(directionMap.get(0).get("id").toString());
            directionIdZero.setTitle(directionMap.get(0).get("title").toString());

            List<Station> stationId0List = new ArrayList<>();
            List<Object> stationListFromMap = (List<Object>) directionMap.get(0).get("stop");

            for(int i=0; i<stationListFromMap.size(); i++) {
                Station station = new Station();
                station.setId(stationListFromMap.get(0).get("id"));
                station.setName();
                station.setLat();
                station.setLon();

                stationId0List.add(station);
            }

            directionIdZero.setStations();

            Extent extent = new Extent();
            extent.setMaxLat((Double) extentMap.get("maxLat"));
            extent.setMinLat((Double) extentMap.get("minLat"));
            extent.setMaxLat((Double) extentMap.get("maxLat"));
            extent.setMaxLat((Double) extentMap.get("maxLat"));
            Route route = new Route();
           // route.set

        }

        return routeList;
    }
}
