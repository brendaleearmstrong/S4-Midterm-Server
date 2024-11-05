package com.misight.model;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "monitoring_stations")
public class MonitoringStation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String location;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "province_id")
    private Province province;

    @OneToMany(mappedBy = "monitoringStation", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Pollutant> pollutants = new HashSet<>();

    public MonitoringStation() {}

    public MonitoringStation(String name, String location, Province province) {
        this.name = name;
        this.location = location;
        this.province = province;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }

    public Set<Pollutant> getPollutants() {
        return pollutants;
    }

    public void setPollutants(Set<Pollutant> pollutants) {
        this.pollutants = pollutants;
    }

    public void addPollutant(Pollutant pollutant) {
        pollutants.add(pollutant);
        pollutant.setMonitoringStation(this);
    }

    public void removePollutant(Pollutant pollutant) {
        pollutants.remove(pollutant);
        pollutant.setMonitoringStation(null);
    }
}
