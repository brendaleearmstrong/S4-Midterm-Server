package com.misight.controller;

import com.misight.model.Pollutant;
import com.misight.service.PollutantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pollutants")
@CrossOrigin(origins = "*")
public class PollutantController {

    private final PollutantService pollutantService;

    @Autowired
    public PollutantController(PollutantService pollutantService) {
        this.pollutantService = pollutantService;
    }

    @GetMapping
    public ResponseEntity<List<Pollutant>> getAllPollutants() {
        return ResponseEntity.ok(pollutantService.getAllPollutants());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pollutant> getPollutantById(@PathVariable Long id) {
        return ResponseEntity.ok(pollutantService.getPollutantById(id));
    }

    @PostMapping
    public ResponseEntity<Pollutant> createPollutant(
            @RequestBody Pollutant pollutant,
            @RequestParam(required = false) Long stationId) {
        return new ResponseEntity<>(pollutantService.createPollutant(pollutant, stationId), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pollutant> updatePollutant(
            @PathVariable Long id,
            @RequestBody Pollutant pollutant) {
        return ResponseEntity.ok(pollutantService.updatePollutant(id, pollutant));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePollutant(@PathVariable Long id) {
        pollutantService.deletePollutant(id);
        return ResponseEntity.noContent().build();
    }
}
