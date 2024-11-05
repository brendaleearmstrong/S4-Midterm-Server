package com.misight.controller;

import com.misight.model.SafetyData;
import com.misight.service.SafetyDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/safetydata")
public class SafetyDataController {

    private final SafetyDataService safetyDataService;

    @Autowired
    public SafetyDataController(SafetyDataService safetyDataService) {
        this.safetyDataService = safetyDataService;
    }

    @PostMapping("/mines/{mineId}")
    public ResponseEntity<SafetyData> createSafetyData(@PathVariable Long mineId, @RequestBody SafetyData safetyData) {
        SafetyData createdSafetyData = safetyDataService.createSafetyData(mineId, safetyData);
        return ResponseEntity.ok(createdSafetyData);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SafetyData> getSafetyDataById(@PathVariable Long id) {
        SafetyData safetyData = safetyDataService.getSafetyDataById(id);
        return ResponseEntity.ok(safetyData);
    }

    @GetMapping
    public List<SafetyData> getAllSafetyData() {
        return safetyDataService.getAllSafetyData();
    }

    @GetMapping("/mines/{mineId}")
    public List<SafetyData> getSafetyDataByMine(@PathVariable Long mineId) {
        return safetyDataService.getSafetyDataByMine(mineId);
    }

    @GetMapping("/mines/{mineId}/daterange")
    public List<SafetyData> getSafetyDataByDateRange(
            @PathVariable Long mineId,
            @RequestParam LocalDate startDate,
            @RequestParam LocalDate endDate) {
        return safetyDataService.getSafetyDataByDateRange(mineId, startDate, endDate);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SafetyData> updateSafetyData(@PathVariable Long id, @RequestBody SafetyData safetyDataDetails) {
        SafetyData updatedSafetyData = safetyDataService.updateSafetyData(id, safetyDataDetails);
        return ResponseEntity.ok(updatedSafetyData);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSafetyData(@PathVariable Long id) {
        safetyDataService.deleteSafetyData(id);
        return ResponseEntity.noContent().build();
    }
}
