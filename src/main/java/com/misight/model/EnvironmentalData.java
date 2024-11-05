package com.misight.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "environmental_data")
public class EnvironmentalData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate dateRecorded;
    private String pollutantType;
    private double level;

    @ManyToOne
    @JoinColumn(name = "station_id")
    private MonitoringStations monitoringStation;

    @ManyToOne
    @JoinColumn(name = "mine_id")  // This is the addition
    private Mines mine;

    public EnvironmentalData() {}

    public EnvironmentalData(LocalDate dateRecorded, String pollutantType, double level, MonitoringStations monitoringStation, Mines mine) {
        this.dateRecorded = dateRecorded;
        this.pollutantType = pollutantType;
        this.level = level;
        this.monitoringStation = monitoringStation;
        this.mine = mine;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public LocalDate getDateRecorded() { return dateRecorded; }
    public void setDateRecorded(LocalDate dateRecorded) { this.dateRecorded = dateRecorded; }

    public String getPollutantType() { return pollutantType; }
    public void setPollutantType(String pollutantType) { this.pollutantType = pollutantType; }

    public double getLevel() { return level; }
    public void setLevel(double level) { this.level = level; }

    public MonitoringStations getMonitoringStation() { return monitoringStation; }
    public void setMonitoringStation(MonitoringStations monitoringStation) { this.monitoringStation = monitoringStation; }

    public Mines getMine() { return mine; }
    public void setMine(Mines mine) { this.mine = mine; }
}
