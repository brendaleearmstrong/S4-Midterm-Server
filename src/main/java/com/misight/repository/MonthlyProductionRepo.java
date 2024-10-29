package com.misight.repository;

import com.misight.model.MonthlyProduction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.YearMonth;
import java.util.List;

@Repository
public interface MonthlyProductionRepo extends JpaRepository<MonthlyProduction, Integer> {
    List<MonthlyProduction> findByMonth(YearMonth month);
}
