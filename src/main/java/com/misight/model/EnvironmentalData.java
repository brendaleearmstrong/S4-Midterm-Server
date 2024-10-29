package com.misight.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "environmental_data")
public class EnvironmentalData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "data_id")
    private Integer dataId;

    @Column(name = "date_recorded", nullable = false)
    private LocalDate dateRecorded;

    @Column(nullable = false)
    private Double value;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pollutant_id", nullable = false)
    private Pollutant pollutant;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "station_id", nullable = false)
    private MonitoringStation monitoringStation;

    public EnvironmentalData() {}

    public EnvironmentalData(LocalDate dateRecorded, Double value, Pollutant pollutant, MonitoringStation monitoringStation) {
        this.dateRecorded = dateRecorded;
        this.value = value;
        this.pollutant = pollutant;
        this.monitoringStation = monitoringStation;
    }

    // Getters
    public Integer getDataId() {
        return dataId;
    }

    public LocalDate getDateRecorded() {
        return dateRecorded;
    }

    public Double getValue() {
        return value;
    }

    public Pollutant getPollutant() {
        return pollutant;
    }

    public MonitoringStation getMonitoringStation() {
        return monitoringStation;
    }

    // Setters
    public void setDateRecorded(LocalDate dateRecorded) {
        this.dateRecorded = dateRecorded;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public void setPollutant(Pollutant pollutant) {
        this.pollutant = pollutant;
    }

    public void setMonitoringStation(MonitoringStation monitoringStation) {
        this.monitoringStation = monitoringStation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EnvironmentalData)) return false;
        EnvironmentalData that = (EnvironmentalData) o;
        return Objects.equals(dataId, that.dataId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dataId);
    }

    @Override
    public String toString() {
        return "EnvironmentalData{" +
                "dataId=" + dataId +
                ", dateRecorded=" + dateRecorded +
                ", value=" + value +
                ", pollutant=" + (pollutant != null ? pollutant.getPollutantName() : "null") +
                ", station=" + (monitoringStation != null ? monitoringStation.getStationName() : "null") +
                '}';
    }
}