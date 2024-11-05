package com.misight.model;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "minerals")
public class Mineral {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mineralId;

    @Column(nullable = false, unique = true)
    private String mineralName;

    @ManyToMany(mappedBy = "minerals")
    private Set<Mine> mines = new HashSet<>();

    public Mineral() {}

    public Mineral(String mineralName) {
        this.mineralName = mineralName;
    }

    public Long getMineralId() {
        return mineralId;
    }

    public String getMineralName() {
        return mineralName;
    }

    public void setMineralName(String mineralName) {
        this.mineralName = mineralName;
    }

    public Set<Mine> getMines() {
        return mines;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Mineral)) return false;
        Mineral mineral = (Mineral) o;
        return mineralId.equals(mineral.mineralId);
    }

    @Override
    public int hashCode() {
        return 31 * mineralId.hashCode();
    }
}