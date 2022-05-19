package com.dizertation.controller;

import com.dizertation.converters.GeoJSONConverter;
import com.dizertation.model.Vehicle;
import com.dizertation.service.ParsingService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class VehiclesController {
    private static final String E2_PAGE_JSON =
            "https://rt.api.opentransport.ro/api/v1/key/f78a2e9a/agency/ro.stpt/command/vehicles?r=r1551&format=json";

    @Autowired
    private ParsingService parsingService;

    @Autowired
    private GeoJSONConverter converter;

    @GetMapping( "vehicles")
    public void main() {
        Map<String, List<Vehicle>> vehicleMap = parsingService.parse(E2_PAGE_JSON);
        converter.convertTo(vehicleMap);
    }
}
