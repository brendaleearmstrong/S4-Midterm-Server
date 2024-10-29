package com.misight.model;
import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "monitoring_stations")
public class MonitoringStation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "station_id")
    private Integer stationId;

    @Column(name = "station_name", nullable = false)
    private String stationName;

    @Column(nullable = false)
    private String location;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "province_id")
    private Province province;

    public MonitoringStation() {}

    public MonitoringStation(String stationName, String location, Province province) {
        this.stationName = stationName;
        this.location = location;
        this.province = province;
    }

    public Integer getStationId() {
        return stationId;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
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

    @Override
    public String toString() {
        return "MonitoringStation{" +
                "stationId=" + stationId +
                ", stationName='" + stationName + '\'' +
                ", location='" + location + '\'' +
                ", province=" + (province != null ? province.getProvinceName() : "null") +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MonitoringStation)) return false;
        MonitoringStation station = (MonitoringStation) o;
        return Objects.equals(stationId, station.stationId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stationId);
    }
}