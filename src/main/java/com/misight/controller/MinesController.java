package com.misight.controller;

import com.misight.model.Mines;
import com.misight.service.MinesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/api/mines")
@CrossOrigin(origins = "*")
public class MinesController {
    private final MinesService minesService;

    @Autowired
    public MinesController(MinesService minesService) {
        this.minesService = minesService;
    }

    @GetMapping
    public ResponseEntity<List<Mines>> getAllMines() {
        return ResponseEntity.ok(minesService.getAllMines());
    }

    @GetMapping("/withMinerals")
    public ResponseEntity<List<Mines>> getAllMinesWithMinerals() {
        return ResponseEntity.ok(minesService.getAllMinesWithMinerals());
    }

    @GetMapping("/mineral/{mineralId}")
    public ResponseEntity<List<Mines>> getMinesWithMineral(@PathVariable Long mineralId) {
        return ResponseEntity.ok(minesService.getMinesWithMineral(mineralId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mines> getMineById(@PathVariable Long id) {
        return minesService.getMineById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Mines> createMine(@RequestBody Mines mine) {
        return ResponseEntity.ok(minesService.createMine(mine));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Mines> updateMine(@PathVariable Long id, @RequestBody Mines mine) {
        return minesService.updateMine(id, mine)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Mines> partialUpdateMine(@PathVariable Long id, @RequestBody Map<String, Object> updates) {
        return minesService.partialUpdateMine(id, updates)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMine(@PathVariable Long id) {
        if (minesService.deleteMine(id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}

