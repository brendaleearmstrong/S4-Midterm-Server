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
    private Set<EnvironmentalData> environmentalData = new HashSet<>();

    public MonitoringStation() {}

    public MonitoringStation(String name, String location, Province province) {
        this.name = name;
        this.location = location;
        this.province = province;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getLocation() { return location; }
    public Province getProvince() { return province; }
    public Set<EnvironmentalData> getEnvironmentalData() { return environmentalData; }

    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setLocation(String location) { this.location = location; }
    public void setProvince(Province province) { this.province = province; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MonitoringStation)) return false;
        MonitoringStation that = (MonitoringStation) o;
        return id != null && id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
