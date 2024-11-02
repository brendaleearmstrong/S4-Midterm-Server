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
        return safetyDataService.getSafetyDataById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<SafetyData> createSafetyData(@RequestBody SafetyData safetyData) {
        SafetyData created = safetyDataService.addSafetyData(safetyData);
        return ResponseEntity.ok(created);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSafetyData(@PathVariable int id) {
        if (safetyDataService.deleteSafetyData(id)) {
            return ResponseEntity.ok("SafetyData deleted successfully.");
        }
        return ResponseEntity.notFound().build();
    }
}
