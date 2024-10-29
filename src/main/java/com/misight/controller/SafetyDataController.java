package com.misight.controller;

import com.misight.model.SafetyData;
import com.misight.service.SafetyDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/safety-data")
public class SafetyDataController {

    private final SafetyDataService safetyDataService;

    @Autowired
    public SafetyDataController(SafetyDataService safetyDataService) {
        this.safetyDataService = safetyDataService;
    }

    @PostMapping
    public ResponseEntity<SafetyData> createSafetyData(@RequestBody SafetyData safetyData) {
        SafetyData addedData = safetyDataService.addSafetyData(safetyData);
        return new ResponseEntity<>(addedData, HttpStatus.CREATED);
    }

    @GetMapping
    public List<SafetyData> getAllSafetyData() {
        return safetyDataService.getAllSafetyData();
    }

    @GetMapping("/{safety_id}")
    public Optional<SafetyData> getSafetyDataById(@PathVariable Integer safety_id) {
        return safetyDataService.getSafetyDataById(safety_id);
    }

    @DeleteMapping("/{safety_id}")
    public ResponseEntity<Void> deleteSafetyData(@PathVariable Integer safety_id) {
        safetyDataService.deleteSafetyData(safety_id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
