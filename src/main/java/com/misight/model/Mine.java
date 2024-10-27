package com.misight.model;

import jakarta.persistence.*;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "mines")
public class Mine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int mine_id;
    public String mine_name;
    public String location;
    public String company;
    public int province_id;

    private Mine(int mineId, String mineName, String location, String company, int provinceId){

        this.mine_id = mineId;
        this.mine_name = mineName;
        this.location = location;
        this.company = company;
        this.province_id = provinceId;
    }

    public Mine(){

    }

    public int getMine_id() {
        return mine_id;
    }

    public String getMine_name() {
        return mine_name;
    }

    public String getLocation() {
        return location;
    }

    public String getCompany() {
        return company;
    }

    public int getProvince_id() {
        return province_id;
    }

    public void setMine_name(String mine_name) {
        this.mine_name = mine_name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setProvince_id(int province_id) {
        this.province_id = province_id;
    }

    @Override
    public String toString() {
        return "Mine{" +
                "mine_id=" + mine_id +
                ", mine_name='" + mine_name + '\'' +
                ", location='" + location + '\'' +
                ", company='" + company + '\'' +
                ", province_id=" + province_id +
                '}';
    }
}

