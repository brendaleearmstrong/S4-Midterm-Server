package com.misight.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.Year;
import java.util.Objects;

@Entity
@Table(name = "yearly_production")
public class YearlyProduction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer production_id;

    @Column(nullable = false)
    private Year year;

    @Column(nullable = false)
    private BigDecimal annual_output;

    @Column(nullable = false)
    private BigDecimal annual_target;

    public YearlyProduction() {}

    public YearlyProduction(Year year, BigDecimal annual_output, BigDecimal annual_target) {
        this.year = year;
        this.annual_output = annual_output;
        this.annual_target = annual_target;
    }

    public Integer getProduction_id() { return production_id; }
    public Year getYear() { return year; }
    public BigDecimal getAnnual_output() { return annual_output; }
    public BigDecimal getAnnual_target() { return annual_target; }

    public void setYear(Year year) { this.year = year; }
    public void setAnnual_output(BigDecimal annual_output) { this.annual_output = annual_output; }
    public void setAnnual_target(BigDecimal annual_target) { this.annual_target = annual_target; }

    @Override
    public String toString() {
        return "YearlyProduction{" +
                "production_id=" + production_id +
                ", year=" + year +
                ", annual_output=" + annual_output +
                ", annual_target=" + annual_target +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof YearlyProduction)) return false;
        YearlyProduction that = (YearlyProduction) o;
        return Objects.equals(production_id, that.production_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(production_id);
    }
}
