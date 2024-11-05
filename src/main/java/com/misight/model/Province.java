package com.misight.model;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "provinces")
public class Province {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long provinceId;

    @Column(nullable = false)
    private String provinceName;

    @OneToMany(mappedBy = "province", cascade = CascadeType.ALL)
    private Set<Mine> mines = new HashSet<>();

    @OneToMany(mappedBy = "province", cascade = CascadeType.ALL)
    private Set<MonitoringStation> monitoringStations = new HashSet<>();

    public Province() {}

    public Province(String provinceName) {
        this.provinceName = provinceName;
    }

    public Long getProvinceId() { return provinceId; }
    public String getProvinceName() { return provinceName; }
    public Set<Mine> getMines() { return mines; }
    public Set<MonitoringStation> getMonitoringStations() { return monitoringStations; }

    public void setProvinceName(String provinceName) { this.provinceName = provinceName; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Province)) return false;
        Province province = (Province) o;
        return provinceId != null && provinceId.equals(province.provinceId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}