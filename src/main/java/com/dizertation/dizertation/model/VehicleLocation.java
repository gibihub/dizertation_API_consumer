package com.dizertation.dizertation.model;

import java.util.Objects;

public class VehicleLocation {
    private double lat;
    private double lon;
    private long time;
    private double speed;
    private double heading;

    public VehicleLocation(double lat, double lon, long time, double speed, double heading) {
        this.lat = lat;
        this.lon = lon;
        this.time = time;
        this.speed = speed;
        this.heading = heading;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getHeading() {
        return heading;
    }

    public void setHeading(double heading) {
        this.heading = heading;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VehicleLocation that = (VehicleLocation) o;
        return Double.compare(that.lat, lat) == 0 && Double.compare(that.lon, lon) == 0 && time == that.time && Double.compare(that.speed, speed) == 0 && Double.compare(that.heading, heading) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lat, lon, time, speed, heading);
    }

    @Override
    public String toString() {
        return "VehicleLocation{" +
                "lat=" + lat +
                ", lon=" + lon +
                ", time=" + time +
                ", speed=" + speed +
                ", heading=" + heading +
                '}';
    }
}
