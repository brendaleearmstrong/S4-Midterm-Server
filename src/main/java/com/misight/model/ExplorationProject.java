package com.misight.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "exploration_projects")
public class ExplorationProject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mine_id", nullable = false)
    private Mine mine;

    @Column(nullable = false)
    private LocalDate startDate;

    @Column(nullable = false)
    private LocalDate endDate;

    @Column(nullable = false, precision = 19, scale = 2)
    private BigDecimal budget;

    public ExplorationProject() {}

    public ExplorationProject(String name, Mine mine, LocalDate startDate, LocalDate endDate, BigDecimal budget) {
        this.name = name;
        this.mine = mine;
        this.startDate = startDate;
        this.endDate = endDate;
        this.budget = budget;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public Mine getMine() { return mine; }
    public LocalDate getStartDate() { return startDate; }
    public LocalDate getEndDate() { return endDate; }
    public BigDecimal getBudget() { return budget; }

    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setMine(Mine mine) { this.mine = mine; }
    public void setStartDate(LocalDate startDate) { this.startDate = startDate; }
    public void setEndDate(LocalDate endDate) { this.endDate = endDate; }
    public void setBudget(BigDecimal budget) { this.budget = budget; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ExplorationProject)) return false;
        ExplorationProject that = (ExplorationProject) o;
        return id != null && id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
