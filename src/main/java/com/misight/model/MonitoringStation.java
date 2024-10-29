package com.misight.model;

import jakarta.persistence.*;

@Entity
@Table(name = "monitoring_stations")
public class MonitoringStation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int station_id;

    @Column(nullable = false)
    private String station_name;

    @Column(nullable = false)
    private String location;

    @Column(nullable = false)
    private int province_id;

    public MonitoringStation() {}

    public MonitoringStation(String station_name, String location, int province_id) {
        this.station_name = station_name;
        this.location = location;
        this.province_id = province_id;
    }

    public int getStation_id() {
        return station_id;
    }

    public String getStation_name() {
        return station_name;
    }

    public void setStation_name(String station_name) {
        this.station_name = station_name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getProvince_id() {
        return province_id;
    }

    public void setProvince_id(int province_id) {
        this.province_id = province_id;
    }

    @Override
    public String toString() {
        return "MonitoringStation{" +
                "station_id=" + station_id +
                ", station_name='" + station_name + '\'' +
                ", location='" + location + '\'' +
                ", province_id=" + province_id +
                '}';
    }
}
