package com.dizertation.controller;

import com.dizertation.model.Vehicle;
import com.dizertation.model.Vehicles;
import com.dizertation.service.ParsingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class VehiclesController {

    private static final String MAIN_PAGE =
            "https://rt.api.opentransport.ro/web/reports/apiCalls/vehiclesApiParams.jsp?a=ro.stpt";

    private static final String E2_PAGE_JSON =
            "https://rt.api.opentransport.ro/api/v1/key/f78a2e9a/agency/ro.stpt/command/vehicles?r=r1551&format=json";

    @Autowired
    private ParsingService parsingService;

    @GetMapping
    public String main(final Model model) {
        List<Vehicle> vehicleList = (List<Vehicle>)parsingService.parse(E2_PAGE_JSON);
        model.addAttribute("vehicle", vehicleList.get(0));
        return MAIN_PAGE;
    }
}
