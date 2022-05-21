package com.dizertation.service;

import com.dizertation.model.route.Route;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface StationParsingService {

    List<Route> parseRoute(String url);
}
