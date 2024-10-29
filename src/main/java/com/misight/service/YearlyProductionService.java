package com.misight.service;

import com.misight.model.YearlyProduction;
import com.misight.repository.YearlyProductionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.Year;
import java.util.List;
import java.util.Optional;

@Service
public class YearlyProductionService {

    private final YearlyProductionRepo productionRepo;

    @Autowired
    public YearlyProductionService(YearlyProductionRepo productionRepo) {
        this.productionRepo = productionRepo;
    }

    public YearlyProduction addProduction(YearlyProduction production) {
        return productionRepo.save(production);
    }

    public List<YearlyProduction> getAllProductions() {
        return productionRepo.findAll();
    }

    public Optional<YearlyProduction> getProductionById(Integer production_id) {
        return productionRepo.findById(production_id);
    }

    public List<YearlyProduction> getProductionByYear(Year year) {
        return productionRepo.findByYear(year);
    }

    public void deleteProduction(Integer production_id) {
        productionRepo.deleteById(production_id);
    }
}
