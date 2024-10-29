package com.misight.controller;

import com.misight.model.YearlyProduction;
import com.misight.service.YearlyProductionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.Year;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/yearly-production")
public class YearlyProductionController {

    private final YearlyProductionService productionService;

    @Autowired
    public YearlyProductionController(YearlyProductionService productionService) {
        this.productionService = productionService;
    }

    @PostMapping
    public ResponseEntity<YearlyProduction> createProduction(@RequestBody YearlyProduction production) {
        YearlyProduction addedProduction = productionService.addProduction(production);
        return new ResponseEntity<>(addedProduction, HttpStatus.CREATED);
    }

    @GetMapping
    public List<YearlyProduction> getAllProductions() {
        return productionService.getAllProductions();
    }

    @GetMapping("/{production_id}")
    public Optional<YearlyProduction> getProductionById(@PathVariable Integer production_id) {
        return productionService.getProductionById(production_id);
    }

    @GetMapping("/year/{year}")
    public List<YearlyProduction> getProductionByYear(@PathVariable("year") int yearValue) {
        Year year = Year.of(yearValue);
        return productionService.getProductionByYear(year);
    }

    @DeleteMapping("/{production_id}")
    public ResponseEntity<Void> deleteProduction(@PathVariable Integer production_id) {
        productionService.deleteProduction(production_id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
