package com.misight.model;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "provinces")
public class Province {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "province_id")
    private int provinceId;

    @Column(nullable = false, name = "province_name")
    private String provinceName;

    @OneToMany(mappedBy = "province", cascade = CascadeType.ALL)
    private Set<Mine> mines = new HashSet<>();

    public Province() {}

    public Province(String provinceName) {
        this.provinceName = provinceName;
    }

    public int getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(int provinceId) {
        this.provinceId = provinceId;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public Set<Mine> getMines() {
        return mines;
    }

    public void setMines(Set<Mine> mines) {
        this.mines = mines;
    }

    @Override
    public String toString() {
        return "Province{" +
                "provinceId=" + provinceId +
                ", provinceName='" + provinceName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Province)) return false;
        Province province = (Province) o;
        return provinceId == province.provinceId;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(provinceId);
    }
}