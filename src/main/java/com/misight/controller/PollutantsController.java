package com.misight.controller;

import com.misight.model.Pollutants;
import com.misight.service.PollutantsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pollutants")
public class PollutantsController {

    @Autowired
    private PollutantsService service;

    @GetMapping
    public List<Pollutants> getAllPollutants() {
        return service.getAllPollutants();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pollutants> getPollutantById(@PathVariable Long id) {
        Pollutants pollutant = service.getPollutantById(id);
        return pollutant != null ? ResponseEntity.ok(pollutant) : ResponseEntity.notFound().build();
    }

    @GetMapping("/name/{name}")
    public List<Pollutants> getPollutantsByName(@PathVariable String name) {
        return service.getPollutantsByName(name);
    }

    @GetMapping("/type/{type}")
    public List<Pollutants> getPollutantsByType(@PathVariable String type) {
        return service.getPollutantsByType(type);
    }

    @PostMapping
    public Pollutants createPollutant(@RequestBody Pollutants pollutant) {
        return service.createPollutant(pollutant);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pollutants> updatePollutant(@PathVariable Long id, @RequestBody Pollutants pollutant) {
        Pollutants updatedPollutant = service.updatePollutant(id, pollutant);
        return updatedPollutant != null ? ResponseEntity.ok(updatedPollutant) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePollutant(@PathVariable Long id) {
        service.deletePollutant(id);
        return ResponseEntity.noContent().build();
    }
}
