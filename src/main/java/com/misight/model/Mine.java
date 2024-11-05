package com.misight.model;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "mine")
public class Mine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "province_id")
    private Province province;

    @ManyToMany
    @JoinTable(
            name = "mine_mineral",
            joinColumns = @JoinColumn(name = "mine_id"),
            inverseJoinColumns = @JoinColumn(name = "mineral_id")
    )
    private Set<Mineral> minerals = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }

    public Set<Mineral> getMinerals() {
        return minerals;
    }

    public void setMinerals(Set<Mineral> minerals) {
        this.minerals = minerals;
    }

    public void addMineral(Mineral mineral) {
        this.minerals.add(mineral);
        mineral.getMines().add(this);
    }

    public void removeMineral(Mineral mineral) {
        this.minerals.remove(mineral);
        mineral.getMines().remove(this);
    }
}

