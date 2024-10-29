package com.misight.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.YearMonth;

@Entity
@Table(name = "monthly_production")
public class MonthlyProduction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer production_id;

    @Column(nullable = false)
    private YearMonth month;

    @Column(nullable = false)
    private BigDecimal total_output;

    @Column(nullable = false)
    private BigDecimal target_output;

    public MonthlyProduction() {}

    public MonthlyProduction(YearMonth month, BigDecimal total_output, BigDecimal target_output) {
        this.month = month;
        this.total_output = total_output;
        this.target_output = target_output;
    }

    public Integer getProduction_id() { return production_id; }
    public YearMonth getMonth() { return month; }
    public BigDecimal getTotal_output() { return total_output; }
    public BigDecimal getTarget_output() { return target_output; }

    public void setMonth(YearMonth month) { this.month = month; }
    public void setTotal_output(BigDecimal total_output) { this.total_output = total_output; }
    public void setTarget_output(BigDecimal target_output) { this.target_output = target_output; }

    @Override
    public String toString() {
        return "MonthlyProduction{" +
                "production_id=" + production_id +
                ", month=" + month +
                ", total_output=" + total_output +
                ", target_output=" + target_output +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MonthlyProduction)) return false;
        MonthlyProduction that = (MonthlyProduction) o;
        return production_id.equals(that.production_id);
    }

    @Override
    public int hashCode() {
        return 31 * production_id;
    }
}
