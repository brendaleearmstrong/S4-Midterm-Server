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
@CrossOrigin(origins = "*")
public class MineralController {
    private final MineralService mineralService;

    @Autowired
    public MineralController(MineralService mineralService) {
        this.mineralService = mineralService;
    }

    @GetMapping
    public ResponseEntity<List<Mineral>> getAllMinerals() {
        return ResponseEntity.ok(mineralService.getAllMinerals());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mineral> getMineralById(@PathVariable Long id) {
        return ResponseEntity.ok(mineralService.getMineralById(id));
    }

    @GetMapping("/{id}/mines")
    public ResponseEntity<Mineral> getMineralWithMines(@PathVariable Long id) {
        return ResponseEntity.ok(mineralService.getMineralWithMines(id));
    }

    @PostMapping
    public ResponseEntity<Mineral> createMineral(@RequestBody Mineral mineral) {
        return new ResponseEntity<>(mineralService.createMineral(mineral), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Mineral> updateMineral(@PathVariable Long id, @RequestBody Mineral mineral) {
        return ResponseEntity.ok(mineralService.updateMineral(id, mineral));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMineral(@PathVariable Long id) {
        mineralService.deleteMineral(id);
        return ResponseEntity.noContent().build();
    }
}
