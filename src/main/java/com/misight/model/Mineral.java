package com.misight.model;

import jakarta.persistence.*;

@Entity
@Table(name = "minerals")
public class Mineral {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mineral_id")
    private Integer mineralId;

    @Column(name = "mineral_name")
    private String mineralName;

    public Mineral(Integer mineralId, String mineralName) {
        this.mineralId = mineralId;
        this.mineralName = mineralName;
    }

    public Mineral() {
    }

    public Integer getMineralId() {
        return mineralId;
    }

    public void setMineralId(Integer mineralId) {
        this.mineralId = mineralId;
    }

    public String getMineralName() {  // This matches what's being called in MineMineral
        return mineralName;
    }

    public void setMineralName(String mineralName) {
        this.mineralName = mineralName;
    }

    @Override
    public String toString() {
        return "Mineral{" +
                "mineralId=" + mineralId +
                ", mineralName='" + mineralName + '\'' +
                '}';
    }
}

