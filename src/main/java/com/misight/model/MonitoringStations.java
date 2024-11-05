package com.misight.model;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "monitoring_stations")
public class MonitoringStations {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String location;

    @OneToMany(mappedBy = "monitoringStation", cascade = CascadeType.ALL)
    private Set<EnvironmentalData> environmentalData = new HashSet<>();

    public MonitoringStations() {}

    public MonitoringStations(String name, String location) {
        this.name = name;
        this.location = location;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public Set<EnvironmentalData> getEnvironmentalData() { return environmentalData; }
    public void setEnvironmentalData(Set<EnvironmentalData> environmentalData) { this.environmentalData = environmentalData; }
}
