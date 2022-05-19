package com.dizertation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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
    public Object parse(String url) {
        return restTemplate.getForObject(url, Object.class);
    }
}
