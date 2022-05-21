package com.dizertation.controller;

import com.dizertation.model.route.Route;
import com.dizertation.service.ParsingService;
import com.dizertation.service.StationParsingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RouteController {
    private static final String E2_ROUTES_URL =
            "https://rt.api.opentransport.ro/api/v1/key/f78a2e9a/agency/ro.stpt/command/routesDetails?r=E2&format=json";

    @Autowired
    private StationParsingService parsingService;

    @GetMapping(path = "routes")
    public List<Route> getRoutesForE2() {
        List<Route> routeList = parsingService.parseRoute(E2_ROUTES_URL);
        return routeList;
    }
}
