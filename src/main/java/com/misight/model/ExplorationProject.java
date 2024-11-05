package com.misight.model;

import jakarta.persistence.*;

@Entity
public class ExplorationProject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String projectName;

    @ManyToOne(optional = true) // allows this relationship to be null if a mine doesn't have an exploration project
    @JoinColumn(name = "mine_id", nullable = true)
    private Mine mine;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Mine getMine() {
        return mine;
    }

    public void setMine(Mine mine) {
        this.mine = mine;
    }
}
