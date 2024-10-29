package com.misight.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "safety_data")
public class SafetyData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer safety_id;

    @Column(nullable = false)
    private String incident_description;

    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false)
    private String location;

    public SafetyData() {}

    public SafetyData(String incident_description, LocalDate date, String location) {
        this.incident_description = incident_description;
        this.date = date;
        this.location = location;
    }

    public Integer getSafety_id() { return safety_id; }
    public String getIncident_description() { return incident_description; }
    public LocalDate getDate() { return date; }
    public String getLocation() { return location; }

    public void setIncident_description(String incident_description) { this.incident_description = incident_description; }
    public void setDate(LocalDate date) { this.date = date; }
    public void setLocation(String location) { this.location = location; }

    @Override
    public String toString() {
        return "SafetyData{" +
                "safety_id=" + safety_id +
                ", incident_description='" + incident_description + '\'' +
                ", date=" + date +
                ", location='" + location + '\'' +
                '}';
    }
}