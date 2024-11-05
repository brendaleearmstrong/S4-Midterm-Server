package com.misight.model;

import jakarta.persistence.*;

@Entity
@Table(name = "provinces")
public class Provinces {  // Class name is plural to match file name

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String abbreviation;

    // Default constructor
    public Provinces() {}

    // Parameterized constructor
    public Provinces(String name, String abbreviation) {
        this.name = name;
        this.abbreviation = abbreviation;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getAbbreviation() { return abbreviation; }
    public void setAbbreviation(String abbreviation) { this.abbreviation = abbreviation; }
}
