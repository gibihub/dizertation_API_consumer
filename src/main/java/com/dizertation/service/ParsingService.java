package com.dizertation.service;

public interface ParsingService {

    /**
     * Service to parse the Json response and convert it to
     * the desired model class
     */

    Object parse(String url);
}
