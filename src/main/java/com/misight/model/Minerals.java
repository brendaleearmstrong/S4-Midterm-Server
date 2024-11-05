package com.misight.model;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "minerals")
public class Minerals {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String type;

    @ManyToMany(mappedBy = "minerals")
    private Set<Mines> mines = new HashSet<>();

    public Minerals() {}

    public Minerals(String name, String type) {
        this.name = name;
        this.type = type;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public Set<Mines> getMines() { return mines; }
    public void setMines(Set<Mines> mines) { this.mines = mines; }
}
