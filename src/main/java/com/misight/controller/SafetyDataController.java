package com.misight.controller;

import com.misight.model.SafetyData;
import com.misight.service.SafetyDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@RestController
@RequestMapping("/api/safetydata")
public class SafetyDataController {

    private final SafetyDataService safetyDataService;
    private static final Logger logger = LoggerFactory.getLogger(SafetyDataController.class);

    @Autowired
    public SafetyDataController(SafetyDataService safetyDataService) {
        this.safetyDataService = safetyDataService;
    }

    @PostMapping("/mines/{mineId}")
    public ResponseEntity<SafetyData> createSafetyData(@PathVariable Long mineId, @RequestBody SafetyData safetyData) {
        logger.debug("POST request received for Mine ID: {}", mineId);
        logger.debug("Received SafetyData: {}", safetyData);

        try {
            SafetyData createdSafetyData = safetyDataService.createSafetyData(mineId, safetyData);
            return ResponseEntity.ok(createdSafetyData);
        } catch (Exception e) {
            logger.error("Error creating SafetyData for Mine ID {}: {}", mineId, e.getMessage());
            return ResponseEntity.status(500).body(null);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<SafetyData> getSafetyDataById(@PathVariable Long id) {
        try {
            SafetyData safetyData = safetyDataService.getSafetyDataById(id);
            return ResponseEntity.ok(safetyData);
        } catch (Exception e) {
            logger.error("Error retrieving SafetyData with ID {}: {}", id, e.getMessage());
            return ResponseEntity.status(500).body(null);
        }
    }

    @GetMapping
    public List<SafetyData> getAllSafetyData() {
        return safetyDataService.getAllSafetyData();
    }

    @GetMapping("/mines/{mineId}")
    public List<SafetyData> getSafetyDataByMine(@PathVariable Long mineId) {
        return safetyDataService.getSafetyDataByMine(mineId);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SafetyData> updateSafetyData(@PathVariable Long id, @RequestBody SafetyData safetyDataDetails) {
        try {
            SafetyData updatedSafetyData = safetyDataService.updateSafetyData(id, safetyDataDetails);
            return ResponseEntity.ok(updatedSafetyData);
        } catch (Exception e) {
            logger.error("Error updating SafetyData with ID {}: {}", id, e.getMessage());
            return ResponseEntity.status(500).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSafetyData(@PathVariable Long id) {
        try {
            safetyDataService.deleteSafetyData(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            logger.error("Error deleting SafetyData with ID {}: {}", id, e.getMessage());
            return ResponseEntity.status(500).build();
        }
    }
}

