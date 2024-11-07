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
        return service.getPollutantById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/category/{category}")
    public List<Pollutants> getPollutantsByCategory(@PathVariable String category) {
        return service.getPollutantsByCategory(category);
    }

    @GetMapping("/name/{name}")
    public List<Pollutants> getPollutantsByName(@PathVariable String name) {
        return service.getPollutantsByName(name);
    }

    @PostMapping
    public ResponseEntity<?> createPollutant(@RequestBody Pollutants pollutant) {
        try {
            Pollutants created = service.createPollutant(pollutant);
            return ResponseEntity.ok(created);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pollutants> updatePollutant(@PathVariable Long id, @RequestBody Pollutants pollutant) {
        return service.updatePollutant(id, pollutant)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePollutant(@PathVariable Long id) {
        if (service.deletePollutant(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
