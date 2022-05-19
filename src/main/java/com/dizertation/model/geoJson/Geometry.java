package com.dizertation.model.geoJson;

import java.util.List;
import java.util.Objects;

public class Geometry {
    private String geometryType;
    private List<Double> coordinates;

    public String getGeometryType() {
        return geometryType;
    }

    public void setGeometryType(String geometryType) {
        this.geometryType = geometryType;
    }

    public List<Double> getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(List<Double> coordinates) {
        this.coordinates = coordinates;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Geometry geometry = (Geometry) o;
        return Objects.equals(geometryType, geometry.geometryType) && Objects.equals(coordinates, geometry.coordinates);
    }

    @Override
    public int hashCode() {
        return Objects.hash(geometryType, coordinates);
    }

    @Override
    public String toString() {
        return "Geometry{" +
                "geometryType='" + geometryType + '\'' +
                ", coordinates=" + coordinates +
                '}';
    }
}
