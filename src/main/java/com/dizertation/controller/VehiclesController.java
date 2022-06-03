package com.dizertation.controller;

import com.dizertation.converters.GeoJSONConverter;
import com.dizertation.model.vehicle.Vehicle;
import com.dizertation.model.geoJson.GeoJSONModel;
import com.dizertation.service.ParsingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VehiclesController {
    @Autowired
    private ParsingService parsingService;

    @Autowired
    private GeoJSONConverter converter;

    @GetMapping( path = "vehicles/{id}" )
    public List<GeoJSONModel> convertVehicleToGeoJSON(@PathVariable String id) {
        String url = String.format("https://rt.api.opentransport.ro/api/v1/key/f78a2e9a/agency/ro.stpt/command/vehicles?r=%s&format=json", id);
        List<Vehicle> vehicleList = parsingService.parseVehicles(url);
        return converter.convertTo(vehicleList);
    }
}
