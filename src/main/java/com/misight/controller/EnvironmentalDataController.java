// Existing controller for EnvironmentalData
package com.misight.controller;

import com.misight.model.EnvironmentalData;
import com.misight.service.EnvironmentalDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/environmental-data")
public class EnvironmentalDataController {

    private final EnvironmentalDataService environmentalDataService;

    @Autowired
    public EnvironmentalDataController(EnvironmentalDataService environmentalDataService) {
        this.environmentalDataService = environmentalDataService;
    }

    @PostMapping
    public ResponseEntity<EnvironmentalData> createEnvironmentalData(@RequestBody EnvironmentalData data) {
        EnvironmentalData addedData = environmentalDataService.addEnvironmentalData(data);
        return new ResponseEntity<>(addedData, HttpStatus.CREATED);
    }

    @GetMapping
    public List<EnvironmentalData> getAllEnvironmentalData() {
        return environmentalDataService.getAllEnvironmentalData();
    }

    @GetMapping("/{data_id}")
    public Optional<EnvironmentalData> getEnvironmentalDataById(@PathVariable Integer data_id) {
        return environmentalDataService.getEnvironmentalDataById(data_id);
    }

    @GetMapping("/date/{date}")
    public List<EnvironmentalData> getEnvironmentalDataByDate(@PathVariable String date) {
        return environmentalDataService.getEnvironmentalDataByDate(LocalDate.parse(date));
    }

    @DeleteMapping("/{data_id}")
    public ResponseEntity<Void> deleteEnvironmentalData(@PathVariable Integer data_id) {
        environmentalDataService.deleteEnvironmentalData(data_id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
