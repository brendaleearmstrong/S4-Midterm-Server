package com.misight.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
@Table(name = "mines")
public class MineDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mine_id")
    @JsonProperty("mine_id")
    private final int mine_id;

    private String company;
    private String location;
    private String mine_name;
    private Integer province_id;

    public MineDTO(int mineId){
        mine_id = mineId;
    }

    public MineDTO(int mineId, String company, String location, String mine_name, Integer province_id) {
        mine_id = mineId;
        this.company = company;
        this.location = location;
        this.mine_name = mine_name;
        this.province_id = province_id;
    }

    public int getMine_id() {
        return mine_id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getMine_name() {
        return mine_name;
    }

    public void setMine_name(String mine_name) {
        this.mine_name = mine_name;
    }

    public Integer getProvince_id() {
        return province_id;
    }

    public void setProvince_id(Integer province_id) {
        this.province_id = province_id;
    }
}
