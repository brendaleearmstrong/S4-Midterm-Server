package com.misight.model;

import jakarta.persistence.*;

@Entity
@Table(name = "mines")
public class Mine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mine_id")
    private int mineId;

    @Column(name = "mine_name")
    private String mineName;

    @Column(name = "location")
    private String location;

    @Column(name = "company")
    private String company;

    @Column(name = "province_id")
    private int provinceId;

    public Mine(int mineId, String mineName, String location, String company, int provinceId) {
        this.mineId = mineId;
        this.mineName = mineName;
        this.location = location;
        this.company = company;
        this.provinceId = provinceId;
    }

    public Mine() {
    }

    public int getMineId() {
        return mineId;
    }

    public void setMineId(int mineId) {
        this.mineId = mineId;
    }

    public String getMineName() {
        return mineName;
    }

    public void setMineName(String mineName) {
        this.mineName = mineName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public int getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(int provinceId) {
        this.provinceId = provinceId;
    }

    @Override
    public String toString() {
        return "Mine{" +
                "mineId=" + mineId +
                ", mineName='" + mineName + '\'' +
                ", location='" + location + '\'' +
                ", company='" + company + '\'' +
                ", provinceId=" + provinceId +
                '}';
    }
}
