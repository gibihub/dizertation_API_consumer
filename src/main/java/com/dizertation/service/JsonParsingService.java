package com.dizertation.service;

import com.dizertation.model.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Service
public class JsonParsingService implements ParsingService{

    @Autowired
    private RestTemplate restTemplate;

    /**
     * Service to parse the Json response and convert it to
     * the desired model class
     *
     * @param url
     */
    @Override
    public Map<String, List<Vehicle>> parse(String url) {
        return restTemplate.getForObject(url, Map.class);
    }
}
