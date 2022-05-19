package com.dizertation.service;

import com.dizertation.model.Vehicle;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ParsingService {

    /**
     * Service to parse the Json response and convert it to
     * the desired model class
     */

    List<Vehicle> parse(String url);
}
