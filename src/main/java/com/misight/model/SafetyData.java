package com.misight.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class SafetyData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int safetyId;

    private int mineId;
    private LocalDate dateRecorded;
    private int lostTimeIncidents;
    private int nearMisses;

    @Enumerated(EnumType.STRING)
    private SafetyLevel safetyLevel;

    public enum SafetyLevel {
        GOOD, FAIR, NEEDS_IMPROVEMENT
    }

    // Getters and Setters

    public int getSafetyId() {
        return safetyId;
    }

    public void setSafetyId(int safetyId) {
        this.safetyId = safetyId;
    }

    public int getMineId() {
        return mineId;
    }

    public void setMineId(int mineId) {
        this.mineId = mineId;
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

    public void setSafetyLevel(SafetyLevel safetyLevel){}
}