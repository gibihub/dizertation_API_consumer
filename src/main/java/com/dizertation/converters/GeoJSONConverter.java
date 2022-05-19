package com.dizertation.converters;

import com.dizertation.model.Vehicle;
import com.dizertation.model.geoJson.GeoJSONModel;
import com.dizertation.model.geoJson.Geometry;
import com.dizertation.model.geoJson.Properties;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GeoJSONConverter {

    public List<GeoJSONModel> convertTo(List<Vehicle> vehicleList) {
        List<GeoJSONModel> actual = new ArrayList<>();
        for (Vehicle vehicle : vehicleList) {

            GeoJSONModel model = new GeoJSONModel();

            Double latitude = vehicle.getLocation().getLat();
            Double longitude = vehicle.getLocation().getLon();

            Geometry modelGeometry = new Geometry();
            modelGeometry.setGeometryType("Point");

            List<Double> coordinates = new ArrayList<>();
            coordinates.add(latitude);
            coordinates.add(longitude);
            modelGeometry.setCoordinates(coordinates);

            Properties modelProperties = new Properties();
            modelProperties.setName(vehicle.getRouteShortName());

            model.setType(vehicle.getId());
            model.setProperties(modelProperties);
            model.setGeometry(modelGeometry);

            actual.add(model);
        }

        return actual;
    }
}
