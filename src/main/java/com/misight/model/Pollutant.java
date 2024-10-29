package com.misight.model;

import jakarta.persistence.*;

@Entity
@Table(name = "pollutants")
public class Pollutant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pollutant_id;

    @Column(nullable = false)
    private String pollutant_name;

    @Column(nullable = false)
    private String unit;

    @Column
    private String description;

    public Pollutant() {}

    public Pollutant(String pollutant_name, String unit, String description) {
        this.pollutant_name = pollutant_name;
        this.unit = unit;
        this.description = description;
    }

    // Getters
    public int getPollutant_id() {
        return pollutant_id;
    }

    public String getPollutant_name() {
        return pollutant_name;
    }

    public String getUnit() {
        return unit;
    }

    public String getDescription() {
        return description;
    }

    // Setters
    public void setPollutant_name(String pollutant_name) {
        this.pollutant_name = pollutant_name;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Pollutant{" +
                "pollutant_id=" + pollutant_id +
                ", pollutant_name='" + pollutant_name + '\'' +
                ", unit='" + unit + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
