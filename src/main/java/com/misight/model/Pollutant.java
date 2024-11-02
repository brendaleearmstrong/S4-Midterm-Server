// Pollutant.java
package com.misight.model;

import jakarta.persistence.*;

@Entity
@Table(name = "pollutants")
public class Pollutant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pollutantId;

    @Column(nullable = false)
    private String pollutantName;

    @Column(nullable = false)
    private String unit;

    @Column
    private String description;

    public Pollutant() {}

    public Pollutant(String pollutantName, String unit, String description) {
        this.pollutantName = pollutantName;
        this.unit = unit;
        this.description = description;
    }

    public int getPollutantId() {
        return pollutantId;
    }

    public void setPollutantId(int pollutantId) {
        this.pollutantId = pollutantId;
    }

    public String getPollutantName() {
        return pollutantName;
    }

    public void setPollutantName(String pollutantName) {
        this.pollutantName = pollutantName;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Pollutant{" +
                "pollutantId=" + pollutantId +
                ", pollutantName='" + pollutantName + '\'' +
                ", unit='" + unit + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
