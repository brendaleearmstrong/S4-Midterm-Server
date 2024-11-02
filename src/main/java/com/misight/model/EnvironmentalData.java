// EnvironmentalData.java
package com.misight.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "environmental_data")
public class EnvironmentalData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int dataId;

    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false)
    private double value;

    @ManyToOne
    @JoinColumn(name = "pollutant_id", nullable = false)
    private Pollutant pollutant;

    @ManyToOne
    @JoinColumn(name = "station_id", nullable = false)
    private MonitoringStation station;

    public EnvironmentalData() {}

    public EnvironmentalData(LocalDate date, double value, Pollutant pollutant, MonitoringStation station) {
        this.date = date;
        this.value = value;
        this.pollutant = pollutant;
        this.station = station;
    }

    public int getDataId() {
        return dataId;
    }

    public void setDataId(int dataId) {
        this.dataId = dataId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public Pollutant getPollutant() {
        return pollutant;
    }

    public void setPollutant(Pollutant pollutant) {
        this.pollutant = pollutant;
    }

    public MonitoringStation getStation() {
        return station;
    }

    public void setStation(MonitoringStation station) {
        this.station = station;
    }

    @Override
    public String toString() {
        return "EnvironmentalData{" +
                "dataId=" + dataId +
                ", date=" + date +
                ", value=" + value +
                ", pollutant=" + pollutant +
                ", station=" + station +
                '}';
    }
}
