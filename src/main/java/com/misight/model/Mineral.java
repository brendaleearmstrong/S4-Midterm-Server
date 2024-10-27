package com.misight.model;

import jakarta.persistence.*;

@Entity
@Table(name = "minerals")
public class Mineral {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer mineral_id;
    public String mineral_name;

    public Mineral(Integer mineral_id, String mineral_name){
        this.mineral_id = mineral_id;
        this.mineral_name = mineral_name;
    }

    public Mineral(){

    }

    public Integer getMineral_id() {
        return mineral_id;
    }

    public String getMineral_name() {
        return mineral_name;
    }

    public void setMineral_name(String mineral_name) {
        this.mineral_name = mineral_name;
    }

    @Override
    public String toString() {
        return "Mineral{" +
                "mineral_id=" + mineral_id +
                ", mineral_name='" + mineral_name + '\'' +
                '}';
    }
}
