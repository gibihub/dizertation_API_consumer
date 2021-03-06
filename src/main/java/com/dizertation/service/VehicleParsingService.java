package com.dizertation.service;

import com.dizertation.converters.GeoJSONConverter;
import com.dizertation.model.geoJson.GeoJSONModel;
import com.dizertation.model.route.Route;
import com.dizertation.model.vehicle.Vehicle;
import com.dizertation.model.vehicle.VehicleLocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class VehicleParsingService implements ParsingService{

    private static final String VEHICLES_URL = "https://rt.api.opentransport.ro/api/v1/key/f78a2e9a/agency/ro.stpt/command/vehicles";

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private GeoJSONConverter converter;

    /**
     * Service to parse the Json response and convert it to
     * the desired model class
     *
     * @param url
     */
    @Override
    public List<Vehicle> parseVehicles(String url) {

        List<Object> vehicles = (List<Object>) restTemplate.getForObject(url, Map.class).get("vehicles");
        List<Vehicle> vehicleList = new ArrayList<>();

        for (Object obj : vehicles) {
            Map<String, Object> map = (Map<String, Object>) obj;

            Map<String, Object> locationMap = (Map<String, Object>) map.get("loc");

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
