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

            Direction directionId1 = new Direction();
            directionId1.setId(directionMap.get(1).get("id").toString());
            directionId1.setTitle(directionMap.get(1).get("title").toString());

            List<Station> stationId0List = new ArrayList<>();
            List<Station> stationId1List = new ArrayList<>();
            List<Object> stationId0ListFromMap = (List<Object>) directionMap.get(0).get("stop");
            List<Object> stationId1ListFromMap = (List<Object>) directionMap.get(1).get("stop");

            for(int i=0; i<stationId0ListFromMap.size(); i++) {

                Map<String, Object> mapFor = (Map<String, Object>) stationId0ListFromMap.get(i);

                Station station = new Station();
                station.setId(mapFor.get("id").toString());
                station.setName(mapFor.get("name").toString());
                station.setLat((Double)mapFor.get("lat"));
                station.setLon((Double)mapFor.get("lon"));

                stationId0List.add(station);
            }
            directionIdZero.setStations(stationId0List);


            for(int i=0; i<stationId1ListFromMap.size(); i++) {

                Map<String, Object> mapFor = (Map<String, Object>) stationId1ListFromMap.get(i);

                Station station = new Station();
                station.setId(mapFor.get("id").toString());
                station.setName(mapFor.get("name").toString());
                station.setLat((Double)mapFor.get("lat"));
                station.setLon((Double)mapFor.get("lon"));

                stationId1List.add(station);
            }

            directionId1.setStations(stationId1List);

            List<Direction> directionList = new ArrayList<>();
            directionList.add(directionIdZero);
            directionList.add(directionId1);

            Extent extent = new Extent();
            extent.setMaxLat((Double) extentMap.get("maxLat"));
            extent.setMinLat((Double) extentMap.get("minLat"));
            extent.setMaxLat((Double) extentMap.get("maxLat"));
            extent.setMaxLat((Double) extentMap.get("maxLat"));

            Route route = new Route();
            route.setDirection(directionList);
            route.setExtent(extent);
            route.setId(map.get("id").toString());
            route.setLongName(map.get("longName").toString());

            routeList.add(route);
        }
        return routeList;
    }
}
