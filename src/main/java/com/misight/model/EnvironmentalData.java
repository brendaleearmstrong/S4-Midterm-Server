package com.misight.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "environmental_data")
public class EnvironmentalData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "pollutant_id", nullable = false)
    private Pollutants pollutant;

    @ManyToOne
    @JoinColumn(name = "station_id", nullable = false)
    private MonitoringStations monitoringStation;

    @ManyToOne
    @JoinColumn(name = "mine_id", nullable = false)
    private Mines mine;

    @Column(name = "measured_value", nullable = false)
    private Double measuredValue;

    @Column(name = "measurement_date", nullable = false)
    private LocalDateTime measurementDate;

    private String notes;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    // Default constructor
    public EnvironmentalData() {}

    // Constructor with essential fields
    public EnvironmentalData(Pollutants pollutant, MonitoringStations monitoringStation,
                             Mines mine, Double measuredValue, LocalDateTime measurementDate) {
        this.pollutant = pollutant;
        this.monitoringStation = monitoringStation;
        this.mine = mine;
        this.measuredValue = measuredValue;
        this.measurementDate = measurementDate;
    }

    // Full constructor
    public EnvironmentalData(Pollutants pollutant, MonitoringStations monitoringStation,
                             Mines mine, Double measuredValue, LocalDateTime measurementDate,
                             String notes) {
        this.pollutant = pollutant;
        this.monitoringStation = monitoringStation;
        this.mine = mine;
        this.measuredValue = measuredValue;
        this.measurementDate = measurementDate;
        this.notes = notes;
    }

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pollutants getPollutant() {
        return pollutant;
    }

    public void setPollutant(Pollutants pollutant) {
        this.pollutant = pollutant;
    }

    public MonitoringStations getMonitoringStation() {
        return monitoringStation;
    }

    public void setMonitoringStation(MonitoringStations monitoringStation) {
        this.monitoringStation = monitoringStation;
    }

    public Mines getMine() {
        return mine;
    }

    public void setMine(Mines mine) {
        this.mine = mine;
    }

    public Double getMeasuredValue() {
        return measuredValue;
    }

    public void setMeasuredValue(Double measuredValue) {
        this.measuredValue = measuredValue;
    }

    public LocalDateTime getMeasurementDate() {
        return measurementDate;
    }

    public void setMeasurementDate(LocalDateTime measurementDate) {
        this.measurementDate = measurementDate;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}