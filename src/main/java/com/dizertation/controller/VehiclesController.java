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
    private static final String E2_PAGE_JSON =
            "https://rt.api.opentransport.ro/api/v1/key/f78a2e9a/agency/ro.stpt/command/vehicles?r=r1551&format=json";

    @Autowired
    private ParsingService parsingService;

    @Autowired
    private GeoJSONConverter converter;

    @GetMapping( path = "vehicles")
    public List<GeoJSONModel> convertVehicleToGeoJSON() {
        List<Vehicle> vehicleList = parsingService.parseVehicles(E2_PAGE_JSON);
        return converter.convertTo(vehicleList);
    }

    @GetMapping(value= "/vehicles/{id}")
    public List<GeoJSONModel> convertVehicleToGeoJSONById(@PathVariable String id){
        return parsingService.parseVehiclesById(id);
    }
}
