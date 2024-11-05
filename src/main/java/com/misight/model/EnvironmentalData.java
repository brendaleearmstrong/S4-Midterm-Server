package com.misight.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "environmental_data")
public class EnvironmentalData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
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

    public Long getId() { return id; }
    public LocalDate getDateRecorded() { return dateRecorded; }
    public Double getValue() { return value; }
    public Pollutant getPollutant() { return pollutant; }
    public MonitoringStation getMonitoringStation() { return monitoringStation; }

    public void setId(Long id) { this.id = id; }
    public void setDateRecorded(LocalDate dateRecorded) { this.dateRecorded = dateRecorded; }
    public void setValue(Double value) { this.value = value; }
    public void setPollutant(Pollutant pollutant) { this.pollutant = pollutant; }
    public void setMonitoringStation(MonitoringStation monitoringStation) { this.monitoringStation = monitoringStation; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EnvironmentalData)) return false;
        EnvironmentalData that = (EnvironmentalData) o;
        return id != null && id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}

