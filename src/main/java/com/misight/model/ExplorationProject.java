package com.misight.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "exploration_projects")
public class ExplorationProject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer project_id;

    @Column(nullable = false)
    private String project_name;

    @Column(nullable = false)
    private String location;

    @Column(nullable = false)
    private LocalDate start_date;

    @Column(nullable = false)
    private LocalDate end_date;

    public ExplorationProject() {
    }

    public ExplorationProject(String project_name, String location, LocalDate start_date, LocalDate end_date) {
        this.project_name = project_name;
        this.location = location;
        this.start_date = start_date;
        this.end_date = end_date;
    }

    public Integer getProject_id() {
        return project_id;
    }

    public String getProject_name() {
        return project_name;
    }

    public String getLocation() {
        return location;
    }

    public LocalDate getStart_date() {
        return start_date;
    }

    public LocalDate getEnd_date() {
        return end_date;
    }

    public void setProject_name(String project_name) {
        this.project_name = project_name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setStart_date(LocalDate start_date) {
        this.start_date = start_date;
    }

    public void setEnd_date(LocalDate end_date) {
        this.end_date = end_date;
    }

    @Override
    public String toString() {
        return "ExplorationProject{" +
                "project_id=" + project_id +
                ", project_name='" + project_name + '\'' +
                ", location='" + location + '\'' +
                ", start_date=" + start_date +
                ", end_date=" + end_date +
                '}';
    }
}
