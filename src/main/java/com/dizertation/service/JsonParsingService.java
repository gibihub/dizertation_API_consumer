package com.dizertation.service;

import com.dizertation.model.Vehicle;
import com.dizertation.model.VehicleLocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class JsonParsingService implements ParsingService{

    @Autowired
    private RestTemplate restTemplate;

    /**
     * Service to parse the Json response and convert it to
     * the desired model class
     *
     * @param url
     */
    @Override
    public List<Vehicle> parse(String url) {

        List<Object> vehicles = (List<Object>) restTemplate.getForObject(url, Map.class).get("vehicles");
        List<Vehicle> vehicleList = new ArrayList<>();

        for (Object obj : vehicles) {
            Map<String, Object> map = (Map<String, Object>) obj;

            Map<String, Object> locationMap = (Map<String, Object>) map.get("loc");

            locationMap.get("lat");
            locationMap.get("lon");

            VehicleLocation vehicleLocation = new VehicleLocation(
                    (Double) locationMap.get("lat"),
                    (Double) locationMap.get("lon"),
                    0,
                    0,
                    0);

            Vehicle vehicle = new Vehicle(
                    (String) map.get("id"),
                    (String) map.get("routeId"),
                    (String) map.get("routeShortName"),
                    (String) map.get("headSign"),
                    (String) map.get("direction"),
                    (String) map.get("vehicleType"),
                    vehicleLocation);

            vehicleList.add(vehicle);

        }
        return vehicleList;
    }
}
