package com.misight.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "pollutants")
public class Pollutants {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private String category;

    @Column(nullable = false)
    private String unit;

    @Column(name = "benchmark_value", nullable = false)
    private Double benchmarkValue;

    @Column(name = "benchmark_type", nullable = false)
    private String benchmarkType;

    @Column(length = 1000)
    private String description;

    @Column(name = "measurement_frequency", nullable = false)
    private String measurementFrequency;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "pollutant")
    private List<EnvironmentalData> measurements;

    // Default constructor
    public Pollutants() {}

    // Constructor with essential fields
    public Pollutants(String name, String category, String unit, Double benchmarkValue,
                      String benchmarkType, String measurementFrequency) {
        this.name = name;
        this.category = category;
        this.unit = unit;
        this.benchmarkValue = benchmarkValue;
        this.benchmarkType = benchmarkType;
        this.measurementFrequency = measurementFrequency;
    }

    // Full constructor
    public Pollutants(String name, String category, String unit, Double benchmarkValue,
                      String benchmarkType, String description, String measurementFrequency) {
        this.name = name;
        this.category = category;
        this.unit = unit;
        this.benchmarkValue = benchmarkValue;
        this.benchmarkType = benchmarkType;
        this.description = description;
        this.measurementFrequency = measurementFrequency;
    }

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

    // Getters and Setters
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Double getBenchmarkValue() {
        return benchmarkValue;
    }

    public void setBenchmarkValue(Double benchmarkValue) {
        this.benchmarkValue = benchmarkValue;
    }

    public String getBenchmarkType() {
        return benchmarkType;
    }

    public void setBenchmarkType(String benchmarkType) {
        this.benchmarkType = benchmarkType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMeasurementFrequency() {
        return measurementFrequency;
    }

    public void setMeasurementFrequency(String measurementFrequency) {
        this.measurementFrequency = measurementFrequency;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public List<EnvironmentalData> getMeasurements() {
        return measurements;
    }

    public void setMeasurements(List<EnvironmentalData> measurements) {
        this.measurements = measurements;
    }
}