package com.misight.controller;

import com.misight.model.EnvironmentalData;
import com.misight.service.EnvironmentalDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;

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
        EnvironmentalData data = service.getDataById(id);
        return data != null ? ResponseEntity.ok(data) : ResponseEntity.notFound().build();
    }

    @GetMapping("/station/{stationId}")
    public List<EnvironmentalData> getDataByStation(@PathVariable Long stationId) {
        return service.getDataByStation(stationId);
    }

    @PostMapping
    public EnvironmentalData createData(@RequestBody EnvironmentalData data) {
        return service.createData(data);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EnvironmentalData> updateData(@PathVariable Long id, @RequestBody EnvironmentalData data) {
        EnvironmentalData updatedData = service.updateData(id, data);
        return updatedData != null ? ResponseEntity.ok(updatedData) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteData(@PathVariable Long id) {
        service.deleteData(id);
        return ResponseEntity.noContent().build();
    }
}
