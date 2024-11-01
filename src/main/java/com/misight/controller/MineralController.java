package com.misight.controller;

import com.misight.model.Mineral;
import com.misight.service.MineralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/minerals")
public class MineralController {
    @Autowired
    private MineralService mineralService;

    @GetMapping
    public List<Mineral> getAllMinerals() {
        return mineralService.getAllMinerals();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mineral> getMineralById(@PathVariable int id) {
        return mineralService.getMineralById(id)
                .map(mineral -> ResponseEntity.ok(mineral))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping
    public Mineral createMineral(@RequestBody Mineral mineral) {
        return mineralService.saveMineral(mineral);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMineral(@PathVariable int id) {
        mineralService.deleteMineral(id);
        return ResponseEntity.noContent().build();
    }
}
