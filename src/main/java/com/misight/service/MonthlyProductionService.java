package com.misight.service;

import com.misight.model.MonthlyProduction;
import com.misight.repository.MonthlyProductionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.YearMonth;
import java.util.List;
import java.util.Optional;

@Service
public class MonthlyProductionService {

    private final MonthlyProductionRepo productionRepo;

    @Autowired
    public MonthlyProductionService(MonthlyProductionRepo productionRepo) {
        this.productionRepo = productionRepo;
    }

    public MonthlyProduction addProduction(MonthlyProduction production) {
        return productionRepo.save(production);
    }

    public List<MonthlyProduction> getAllProductions() {
        return productionRepo.findAll();
    }

    public Optional<MonthlyProduction> getProductionById(Integer production_id) {
        return productionRepo.findById(production_id);
    }

    public List<MonthlyProduction> getProductionByMonth(YearMonth month) {
        return productionRepo.findByMonth(month);
    }

    public void deleteProduction(Integer production_id) {
        productionRepo.deleteById(production_id);
    }
}
