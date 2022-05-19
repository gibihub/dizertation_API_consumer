package com.dizertation.converters;

import com.dizertation.model.Vehicle;
import com.dizertation.model.geoJson.GeoJSONModel;
import com.dizertation.model.geoJson.Geometry;
import com.dizertation.model.geoJson.Properties;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class GeoJSONConverter {

    public List<GeoJSONModel> convertTo(Map<String, List<Vehicle>> vehicleMap) {
        List<GeoJSONModel> actual = new ArrayList<GeoJSONModel>();
        for (int i = 0 ; i < vehicleMap.get("vehicles").size(); i++) {
            GeoJSONModel model = new GeoJSONModel();

            Double latitude = vehicleMap.get("vehicles").get(i).get("loc").get("lat");
            Double longitude = vehicleMap.get("vehicles").get(i).get("loc").get("lon");

            Geometry modelGeometry = new Geometry();
            modelGeometry.setGeometryType("Point");

            List<Double> coordinates = new ArrayList<>();
            coordinates.add(latitude);
            coordinates.add(longitude);

            modelGeometry.setCoordinates(coordinates);

            Properties modelProperties = new Properties();
            modelProperties.setName(vehicleMap.get("vehicles").get(i).get("routeShortName"));

            model.setType(vehicleMap.get("vehicles").get(i).get("id"));
            model.setProperties(modelProperties);
            model.setGeometry(modelGeometry);

            actual.add(model);
        }

        return actual;
    }
}
