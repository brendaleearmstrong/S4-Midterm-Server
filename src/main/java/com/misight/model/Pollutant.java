package com.misight.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "pollutants")
public class Pollutant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String type;  // e.g., dust, silica

    @Column(nullable = false)
    private String measurement;  // Measurement unit

    @Column(nullable = false)
    private Double measuredValue;

    @Column(nullable = false)
    private LocalDateTime timestamp;  // Timestamp for when measurement is taken

    @ManyToOne
    @JoinColumn(name = "monitoring_station_id")
    private MonitoringStation monitoringStation;  // Optional association with Monitoring Station

    // Constructors
    public Pollutant() {
    }

    public Pollutant(String name, String type, String measurement, Double measuredValue, LocalDateTime timestamp, MonitoringStation monitoringStation) {
        this.name = name;
        this.type = type;
        this.measurement = measurement;
        this.measuredValue = measuredValue;
        this.timestamp = timestamp;
        this.monitoringStation = monitoringStation;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMeasurement() {
        return measurement;
    }

    public void setMeasurement(String measurement) {
        this.measurement = measurement;
    }

    public Double getMeasuredValue() {
        return measuredValue;
    }

    public void setMeasuredValue(Double measuredValue) {
        this.measuredValue = measuredValue;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public MonitoringStation getMonitoringStation() {
        return monitoringStation;
    }

    public void setMonitoringStation(MonitoringStation monitoringStation) {
        this.monitoringStation = monitoringStation;
    }

    // hashCode, equals, and toString
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pollutant pollutant = (Pollutant) o;
        return Objects.equals(id, pollutant.id) &&
                Objects.equals(name, pollutant.name) &&
                Objects.equals(type, pollutant.type) &&
                Objects.equals(measurement, pollutant.measurement) &&
                Objects.equals(measuredValue, pollutant.measuredValue) &&
                Objects.equals(timestamp, pollutant.timestamp) &&
                Objects.equals(monitoringStation, pollutant.monitoringStation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, type, measurement, measuredValue, timestamp, monitoringStation);
    }

    @Override
    public String toString() {
        return "Pollutant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", measurement='" + measurement + '\'' +
                ", measuredValue=" + measuredValue +
                ", timestamp=" + timestamp +
                ", monitoringStation=" + monitoringStation +
                '}';
    }
}
