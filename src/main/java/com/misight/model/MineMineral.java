package com.misight.model;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "mine_minerals")
public class MineMineral {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mine_id", nullable = false)
    private Mine mine;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mineral_id", nullable = false)
    private Mineral mineral;

    public MineMineral() {}

    public MineMineral(Mine mine, Mineral mineral) {
        this.mine = mine;
        this.mineral = mineral;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Mine getMine() {
        return mine;
    }

    public void setMine(Mine mine) {
        this.mine = mine;
    }

    public Mineral getMineral() {
        return mineral;
    }

    public void setMineral(Mineral mineral) {
        this.mineral = mineral;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MineMineral)) return false;
        MineMineral that = (MineMineral) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "MineMineral{" +
                "id=" + id +
                ", mine=" + mine.getMineName() +
                ", mineral=" + mineral.getMineralName() +
                '}';
    }
}
