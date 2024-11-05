package com.misight.model;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "exploration_projects")
public class ExplorationProjects {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String projectName;
    private String description;

    @ManyToOne
    @JoinColumn(name = "mine_id")
    private Mines mine;

    public ExplorationProjects() {}

    public ExplorationProjects(String projectName, String description, Mines mine) {
        this.projectName = projectName;
        this.description = description;
        this.mine = mine;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getProjectName() { return projectName; }
    public void setProjectName(String projectName) { this.projectName = projectName; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Mines getMine() { return mine; }
    public void setMine(Mines mine) { this.mine = mine; }
}
