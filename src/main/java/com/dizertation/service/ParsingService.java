package com.dizertation.service;

import com.dizertation.model.geoJson.GeoJSONModel;
import com.dizertation.model.route.Route;
import com.dizertation.model.vehicle.Vehicle;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ParsingService {

    /**
     * Service to parse the Json response and convert it to
     * the desired model class
     */

    List<Vehicle> parseVehicles(String url);
}
