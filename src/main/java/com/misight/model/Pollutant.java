package com.misight.model;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "pollutants")
public class Pollutant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String unit;

    private String description;

    @OneToMany(mappedBy = "pollutant", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<EnvironmentalData> environmentalData = new HashSet<>();

    public Pollutant() {}

    public Pollutant(String name, String unit, String description) {
        this.name = name;
        this.unit = unit;
        this.description = description;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getUnit() { return unit; }
    public String getDescription() { return description; }
    public Set<EnvironmentalData> getEnvironmentalData() { return environmentalData; }

    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setUnit(String unit) { this.unit = unit; }
    public void setDescription(String description) { this.description = description; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pollutant)) return false;
        Pollutant pollutant = (Pollutant) o;
        return id != null && id.equals(pollutant.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
