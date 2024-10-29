package com.misight.model;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "safety_data")
public class SafetyData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int safetyId;

    @Column(nullable = false)
    private String safetyLevel;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mine_id", nullable = false)
    private Mine mine;

    public SafetyData() {}

    public SafetyData(String safetyLevel, Mine mine) {
        this.safetyLevel = safetyLevel;
        this.mine = mine;
    }

    public int getSafetyId() {
        return safetyId;
    }

    public String getSafetyLevel() {
        return safetyLevel;
    }

    public void setSafetyLevel(String safetyLevel) {
        this.safetyLevel = safetyLevel;
    }

    public Mine getMine() {
        return mine;
    }

    public void setMine(Mine mine) {
        this.mine = mine;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SafetyData)) return false;
        SafetyData that = (SafetyData) o;
        return safetyId == that.safetyId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(safetyId);
    }

    @Override
    public String toString() {
        return "SafetyData{" +
                "safetyId=" + safetyId +
                ", safetyLevel='" + safetyLevel + '\'' +
                ", mine=" + (mine != null ? mine.getMineName() : "null") +
                '}';
    }
}

