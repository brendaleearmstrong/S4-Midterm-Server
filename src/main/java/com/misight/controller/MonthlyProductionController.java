package com.misight.controller;

import com.misight.model.MonthlyProduction;
import com.misight.service.MonthlyProductionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.YearMonth;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/monthly-production")
public class MonthlyProductionController {

    private final MonthlyProductionService productionService;

    @Autowired
    public MonthlyProductionController(MonthlyProductionService productionService) {
        this.productionService = productionService;
    }

    @PostMapping
    public ResponseEntity<MonthlyProduction> createProduction(@RequestBody MonthlyProduction production) {
        MonthlyProduction addedProduction = productionService.addProduction(production);
        return new ResponseEntity<>(addedProduction, HttpStatus.CREATED);
    }

    @GetMapping
    public List<MonthlyProduction> getAllProductions() {
        return productionService.getAllProductions();
    }

    @GetMapping("/{production_id}")
    public Optional<MonthlyProduction> getProductionById(@PathVariable Integer production_id) {
        return productionService.getProductionById(production_id);
    }

    @GetMapping("/month/{month}")
    public List<MonthlyProduction> getProductionByMonth(@PathVariable("month") String monthString) {
        YearMonth month = YearMonth.parse(monthString);
        return productionService.getProductionByMonth(month);
    }

    @DeleteMapping("/{production_id}")
    public ResponseEntity<Void> deleteProduction(@PathVariable Integer production_id) {
        productionService.deleteProduction(production_id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
