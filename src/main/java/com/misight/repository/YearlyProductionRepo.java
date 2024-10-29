package com.misight.repository;

import com.misight.model.YearlyProduction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.Year;
import java.util.List;

@Repository
public interface YearlyProductionRepo extends JpaRepository<YearlyProduction, Integer> {
    List<YearlyProduction> findByYear(Year year);
}