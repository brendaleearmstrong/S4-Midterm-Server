package com.misight.model;

import jakarta.persistence.*;

@Entity
@Table(name = "mine_minerals")
public class MineMineral {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mine_id")
    private Mine mine;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mineral_id")
    private Mineral mineral;

    public MineMineral() {}

    public MineMineral(Mine mine, Mineral mineral) {
        this.mine = mine;
        this.mineral = mineral;
    }

    public Long getId() {
        return id;
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
}