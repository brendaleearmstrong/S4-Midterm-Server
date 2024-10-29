package com.misight.model;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "pollutants")
public class Pollutant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pollutantId;

    @Column(name = "pollutant_name", nullable = false)
    private String pollutantName;

    @Column(nullable = false)
    private String unit;

    @Column
    private String description;

    @OneToMany(mappedBy = "pollutant", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<EnvironmentalData> environmentalData = new HashSet<>();

    public Pollutant() {}

    public Pollutant(String pollutantName, String unit, String description) {
        this.pollutantName = pollutantName;
        this.unit = unit;
        this.description = description;
    }

    public int getPollutantId() {
        return pollutantId;
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

    public Set<EnvironmentalData> getEnvironmentalData() {
        return environmentalData;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pollutant)) return false;
        Pollutant pollutant = (Pollutant) o;
        return pollutantId == pollutant.pollutantId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(pollutantId);
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