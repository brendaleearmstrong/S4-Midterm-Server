package com.misight.controller;

import com.misight.model.SafetyData;
import com.misight.service.SafetyDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/safety-data")
@CrossOrigin(origins = "*")
public class SafetyDataController {
    private final SafetyDataService safetyDataService;

    @Autowired
    public SafetyDataController(SafetyDataService safetyDataService) {
        this.safetyDataService = safetyDataService;
    }

    @GetMapping
    public ResponseEntity<List<SafetyData>> getAllSafetyData() {
        return ResponseEntity.ok(safetyDataService.getAllSafetyData());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SafetyData> getSafetyDataById(@PathVariable Long id) {
        return ResponseEntity.ok(safetyDataService.getSafetyDataById(id));
    }

    @GetMapping("/mine/{mineId}")
    public ResponseEntity<List<SafetyData>> getSafetyDataByMine(@PathVariable Long mineId) {
        return ResponseEntity.ok(safetyDataService.getSafetyDataByMine(mineId));
    }

    @GetMapping("/mine/{mineId}/range")
    public ResponseEntity<List<SafetyData>> getSafetyDataByDateRange(
            @PathVariable Long mineId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        return ResponseEntity.ok(safetyDataService.getSafetyDataByDateRange(mineId, startDate, endDate));
    }

    @PostMapping("/mine/{mineId}")
    public ResponseEntity<SafetyData> createSafetyData(
            @PathVariable Long mineId,
            @RequestBody SafetyData safetyData) {
        return new ResponseEntity<>(
                safetyDataService.createSafetyData(mineId, safetyData),
                HttpStatus.CREATED
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<SafetyData> updateSafetyData(
            @PathVariable Long id,
            @RequestBody SafetyData safetyData) {
        return ResponseEntity.ok(safetyDataService.updateSafetyData(id, safetyData));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSafetyData(@PathVariable Long id) {
        safetyDataService.deleteSafetyData(id);
        return ResponseEntity.noContent().build();
    }
}
