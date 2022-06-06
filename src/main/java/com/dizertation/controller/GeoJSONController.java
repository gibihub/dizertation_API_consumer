package com.dizertation.controller;

import com.dizertation.database.model.GeoJSON;
import com.dizertation.database.repository.GeoJSONRepository;
import com.dizertation.model.geoJson.GeoJSONModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class GeoJSONController {
    @Autowired
    private GeoJSONRepository repository;

    @Autowired
    private VehiclesController vehiclesController;

    @PostMapping("/addVehicle/{id}")
    public List<GeoJSON> saveGeoJSON(@PathVariable String id) {
        List<GeoJSONModel> geoJSONModelList = vehiclesController.convertVehicleToGeoJSON(id);
        List<GeoJSON> geoJSONList = new ArrayList<>();

        repository.deleteAll();

        for(GeoJSONModel model: geoJSONModelList) {
            GeoJSON geoJSON = new GeoJSON();

            geoJSON.setId(model.getType());
            geoJSON.setLatitude(model.getGeometry().getCoordinates().get(0));
            geoJSON.setLongitude(model.getGeometry().getCoordinates().get(1));
            geoJSON.setName(model.getProperties().getName());

            geoJSONList.add(geoJSON);
            repository.save(geoJSON);
        }
        return geoJSONList;
    }

    @GetMapping("/findAllGeoJSON")
    public List<GeoJSON> getAllGeoJSON() {
        return repository.findAll();
    }

    @GetMapping("/findAllGeoJSON/{id}")
    public Optional<GeoJSON> getGeoJSON(@PathVariable String id) {
        return repository.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteGeoJSON(@PathVariable String id) {
        repository.deleteById(id);
        return "GeoJSON deleted with id= " + id;
    }
}
