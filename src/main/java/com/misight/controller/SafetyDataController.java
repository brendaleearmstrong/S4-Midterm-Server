package com.misight.controller;

import com.misight.model.SafetyData;
import com.misight.service.SafetyDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/safety-data")
public class SafetyDataController {

    private final SafetyDataService safetyDataService;

    @Autowired
    public SafetyDataController(SafetyDataService safetyDataService) {
        this.safetyDataService = safetyDataService;
    }

    @GetMapping
    public List<SafetyData> getAllSafetyData() {
        return safetyDataService.getAllSafetyData();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SafetyData> getSafetyDataById(@PathVariable int id) {
        SafetyData safetyData = safetyDataService.getSafetyDataById(id).orElse(null);
        if (safetyData == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(safetyData);
    }

    @PostMapping
    public SafetyData createSafetyData(@RequestParam int mineId,
                                       @RequestParam int lostTimeIncidents,
                                       @RequestParam int nearMisses) {
        return safetyDataService.addSafetyData(mineId, lostTimeIncidents, nearMisses);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSafetyData(@PathVariable int id) {
        if (safetyDataService.deleteSafetyData(id)) {
            return ResponseEntity.ok("SafetyData deleted successfully.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
