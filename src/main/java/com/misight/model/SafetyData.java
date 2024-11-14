package com.misight.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "safety_data")
public class SafetyData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mine_id")
    @JsonIgnoreProperties({"safetyData", "environmentalData", "minerals", "province"})
    private Mines mine;

    @Column(name = "date_recorded", nullable = false)
    private LocalDate dateRecorded;

    @Column(name = "lost_time_incidents")
    private int lostTimeIncidents;

    @Column(name = "near_misses")
    private int nearMisses;

    @Enumerated(EnumType.STRING)
    @Column(name = "safety_level")
    private SafetyLevel safetyLevel;

    public enum SafetyLevel {
        CRITICAL, FAIR, GOOD, EXCELLENT
    }

    public SafetyData() {}

    public SafetyData(LocalDate dateRecorded, int lostTimeIncidents, int nearMisses, SafetyLevel safetyLevel, Mines mine) {
        this.dateRecorded = dateRecorded;
        this.lostTimeIncidents = lostTimeIncidents;
        this.nearMisses = nearMisses;
        this.safetyLevel = safetyLevel;
        this.mine = mine;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Mines getMine() {
        return mine;
    }

    public void setMine(Mines mine) {
        this.mine = mine;
    }

    public LocalDate getDateRecorded() {
        return dateRecorded;
    }

    public void setDateRecorded(LocalDate dateRecorded) {
        this.dateRecorded = dateRecorded;
    }

    public int getLostTimeIncidents() {
        return lostTimeIncidents;
    }

    public void setLostTimeIncidents(int lostTimeIncidents) {
        this.lostTimeIncidents = lostTimeIncidents;
    }

    public int getNearMisses() {
        return nearMisses;
    }

    public void setNearMisses(int nearMisses) {
        this.nearMisses = nearMisses;
    }

    public SafetyLevel getSafetyLevel() {
        return safetyLevel;
    }

    public void setSafetyLevel(SafetyLevel safetyLevel) {
        this.safetyLevel = safetyLevel;
    }
}
