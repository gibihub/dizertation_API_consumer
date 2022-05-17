package com.dizertation.dizertation.model;

import java.util.List;
import java.util.Objects;

public class Vehicles {
    private List<Vehicle> vehicleList;

    public Vehicles(List<Vehicle> vehicleList) {
        this.vehicleList = vehicleList;
    }

    public List<Vehicle> getVehicleList() {
        return vehicleList;
    }

    public void setVehicleList(List<Vehicle> vehicleList) {
        this.vehicleList = vehicleList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicles vehicles = (Vehicles) o;
        return Objects.equals(vehicleList, vehicles.vehicleList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vehicleList);
    }

    @Override
    public String toString() {
        return "Vehicles{" +
                "vehicleList=" + vehicleList +
                '}';
    }


}
