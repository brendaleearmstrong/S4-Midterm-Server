package com.misight.model;

import jakarta.persistence.*;

@Entity
@Table(name = "provinces")
public class Province {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int province_id;

    @Column(nullable = false)
    private String province_name;

    public Province() {}

    public Province(String province_name) {
        this.province_name = province_name;
    }

    public int getProvince_id() {
        return province_id;
    }

    public String getProvince_name() {
        return province_name;
    }

    public void setProvince_name(String province_name) {
        this.province_name = province_name;
    }

    @Override
    public String toString() {
        return "Province{" +
                "province_id=" + province_id +
                ", province_name='" + province_name + '\'' +
                '}';
    }
}