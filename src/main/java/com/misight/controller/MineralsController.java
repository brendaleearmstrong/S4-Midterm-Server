package com.misight.controller;

import com.misight.model.Minerals;
import com.misight.service.MineralsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/minerals")
public class MineralsController {

    @Autowired
    private MineralsService service;

    @GetMapping
    public List<Minerals> getAllMinerals() {
        return service.getAllMinerals();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Minerals> getMineralById(@PathVariable Long id) {
        Minerals mineral = service.getMineralById(id);
        return mineral != null ? ResponseEntity.ok(mineral) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public Minerals createMineral(@RequestBody Minerals mineral) {
        return service.createMineral(mineral);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Minerals> updateMineral(@PathVariable Long id, @RequestBody Minerals mineral) {
        Minerals updatedMineral = service.updateMineral(id, mineral);
        return updatedMineral != null ? ResponseEntity.ok(updatedMineral) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMineral(@PathVariable Long id) {
        service.deleteMineral(id);
        return ResponseEntity.noContent().build();
    }
}
