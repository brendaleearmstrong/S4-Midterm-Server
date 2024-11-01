package com.misight.model;

public class MineDTO {
    private Integer mine_id;
    private String mine_name;
    private String location;
    private String company;
    private Integer province_id; // Just an ID instead of an object

    // Getters and setters

    public MineDTO(){}

    public MineDTO(Integer mine_id, String mine_name, String location, String company, Integer province_id) {
        this.mine_id = mine_id;
        this.mine_name = mine_name;
        this.location = location;
        this.company = company;
        this.province_id = province_id;
    }

    public Integer getMine_id() {
        return mine_id;
    }

    public void setMine_id(Integer mine_id) {
        this.mine_id = mine_id;
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

    public String getMineName() {
        return mine_name;
    }

    public void setMineName(String mineName) {
        this.mine_name = mineName;
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

    public Integer getProvinceId() {
        return province_id;
    }

    public void setProvinceId(Integer provinceId) {
        this.province_id = provinceId;
    }
}

