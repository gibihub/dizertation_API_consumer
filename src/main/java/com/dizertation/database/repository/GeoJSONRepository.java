package com.dizertation.database.repository;

import com.dizertation.database.model.GeoJSON;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeoJSONRepository extends MongoRepository<GeoJSON, String> {
}
