// MonitoringStation.java
package com.misight.model;

import jakarta.persistence.*;

@Entity
@Table(name = "monitoring_stations")
public class MonitoringStation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int stationId;

    @Column(nullable = false)
    private String stationName;

    @Column(nullable = false)
    private String location;

    @Column(nullable = false)
    private int provinceId;

    public MonitoringStation() {}

    public MonitoringStation(String stationName, String location, int provinceId) {
        this.stationName = stationName;
        this.location = location;
        this.provinceId = provinceId;
    }

    public int getStationId() {
        return stationId;
    }

    public void setStationId(int stationId) {
        this.stationId = stationId;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(int provinceId) {
        this.provinceId = provinceId;
    }

    @Override
    public String toString() {
        return "MonitoringStation{" +
                "stationId=" + stationId +
                ", stationName='" + stationName + '\'' +
                ", location='" + location + '\'' +
                ", provinceId=" + provinceId +
                '}';
    }
}
