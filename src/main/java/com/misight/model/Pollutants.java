package com.misight.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "pollutants")
public class Pollutants {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String type; // e.g., dust, silica
    private String measurement;
    private double measuredValue;
    private LocalDate timestamp;

    @ManyToOne
    @JoinColumn(name = "station_id", nullable = true)
    private MonitoringStations monitoringStation;

    public Pollutants() {}

    public Pollutants(String name, String type, String measurement, double measuredValue, LocalDate timestamp, MonitoringStations monitoringStation) {
        this.name = name;
        this.type = type;
        this.measurement = measurement;
        this.measuredValue = measuredValue;
        this.timestamp = timestamp;
        this.monitoringStation = monitoringStation;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getMeasurement() { return measurement; }
    public void setMeasurement(String measurement) { this.measurement = measurement; }

    public double getMeasuredValue() { return measuredValue; }
    public void setMeasuredValue(double measuredValue) { this.measuredValue = measuredValue; }

    public LocalDate getTimestamp() { return timestamp; }
    public void setTimestamp(LocalDate timestamp) { this.timestamp = timestamp; }

    public MonitoringStations getMonitoringStation() { return monitoringStation; }
    public void setMonitoringStation(MonitoringStations monitoringStation) { this.monitoringStation = monitoringStation; }
}
