package com.dizertation.controller;

import com.dizertation.model.Vehicle;
import com.dizertation.model.Vehicles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/myVehicles")
public class VehiclesController {

    @Autowired
    private RestTemplate restTemplate;
    
    @GetMapping("/vehicles")
    public List<Vehicle> getVehiclesById(@RequestParam(value = "r") String id) {
        String url = "https://rt.api.opentransport.ro/api/v1/key/f78a2e9a/agency/ro.stpt/command/vehicles?r=r1551&format=json";
        Vehicle[] vehicles= restTemplate.getForObject(url, Vehicle[].class);
        List<Vehicle> vehiclesList = Arrays.asList(vehicles);
        System.out.println("Bus id : " + vehiclesList.get(0).getId());
        return vehiclesList;
    }

}
