package com.dizertation.dizertation.model;

import java.util.Objects;

public class Vehicle {
    private String id;
    private String routeId;
    private String routeShortName;
    private String headSign;
    private String direction;
    private String vehicleType;
    private VehicleLocation location;

    public Vehicle(String id, String routeId, String routeShortName, String headSign, String direction, String vehicleType, VehicleLocation location) {
        this.id = id;
        this.routeId = routeId;
        this.routeShortName = routeShortName;
        this.headSign = headSign;
        this.direction = direction;
        this.vehicleType = vehicleType;
        this.location = location;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRouteId() {
        return routeId;
    }

    public void setRouteId(String routeId) {
        this.routeId = routeId;
    }

    public String getRouteShortName() {
        return routeShortName;
    }

    public void setRouteShortName(String routeShortName) {
        this.routeShortName = routeShortName;
    }

    public String getHeadSign() {
        return headSign;
    }

    public void setHeadSign(String headSign) {
        this.headSign = headSign;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public VehicleLocation getLocation() {
        return location;
    }

    public void setLocation(VehicleLocation location) {
        this.location = location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return Objects.equals(id, vehicle.id) && Objects.equals(routeId, vehicle.routeId) && Objects.equals(routeShortName, vehicle.routeShortName) && Objects.equals(headSign, vehicle.headSign) && Objects.equals(direction, vehicle.direction) && Objects.equals(vehicleType, vehicle.vehicleType) && Objects.equals(location, vehicle.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, routeId, routeShortName, headSign, direction, vehicleType, location);
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id='" + id + '\'' +
                ", routeId='" + routeId + '\'' +
                ", routeShortName='" + routeShortName + '\'' +
                ", headSign='" + headSign + '\'' +
                ", direction='" + direction + '\'' +
                ", vehicleType='" + vehicleType + '\'' +
                ", location=" + location +
                '}';
    }
}
