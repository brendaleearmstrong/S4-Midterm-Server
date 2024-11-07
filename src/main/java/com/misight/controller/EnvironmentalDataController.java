package com.misight.controller;

import com.misight.model.EnvironmentalData;
import com.misight.service.EnvironmentalDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/environmental-data")
public class EnvironmentalDataController {

    @Autowired
    private EnvironmentalDataService service;

    @GetMapping
    public List<EnvironmentalData> getAllData() {
        return service.getAllData();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnvironmentalData> getDataById(@PathVariable Long id) {
        return service.getDataById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/station/{stationId}")
    public List<EnvironmentalData> getDataByStation(@PathVariable Long stationId) {
        return service.getDataByStation(stationId);
    }

    @GetMapping("/mine/{mineId}")
    public List<EnvironmentalData> getDataByMine(@PathVariable Long mineId) {
        return service.getDataByMine(mineId);
    }

    @GetMapping("/date-range")
    public List<EnvironmentalData> getDataByDateRange(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime start,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime end) {
        return service.getDataByDateRange(start, end);
    }

    @PostMapping
    public ResponseEntity<EnvironmentalData> createData(@RequestBody EnvironmentalData data) {
        return ResponseEntity.ok(service.createData(data));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EnvironmentalData> updateData(@PathVariable Long id, @RequestBody EnvironmentalData data) {
        return service.updateData(id, data)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteData(@PathVariable Long id) {
        if (service.deleteData(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}