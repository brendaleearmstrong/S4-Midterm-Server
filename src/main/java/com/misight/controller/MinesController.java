package com.misight.controller;

import com.misight.model.Mines;
import com.misight.model.Minerals;
import com.misight.service.MinesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/mines")
public class MinesController {

    @Autowired
    private MinesService service;

    @GetMapping
    public List<Mines> getAllMines() {
        return service.getAllMines();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mines> getMineById(@PathVariable Long id) {
        Mines mine = service.getMineById(id);
        return mine != null ? ResponseEntity.ok(mine) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public Mines createMine(@RequestBody Mines mine) {
        return service.createMine(mine);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Mines> updateMine(@PathVariable Long id, @RequestBody Mines mine) {
        Mines updatedMine = service.updateMine(id, mine);
        return updatedMine != null ? ResponseEntity.ok(updatedMine) : ResponseEntity.notFound().build();
    }

    @PatchMapping("/{id}/province/{provinceId}")
    public ResponseEntity<Mines> updateMineProvince(@PathVariable Long id, @PathVariable Long provinceId) {
        Mines updatedMine = service.updateMineProvince(id, provinceId);
        return ResponseEntity.ok(updatedMine);
    }

    @GetMapping("/{mineId}/minerals")
    public ResponseEntity<Set<Minerals>> getMineMinerals(@PathVariable Long mineId) {
        Set<Minerals> minerals = service.getMineMinerals(mineId);
        return ResponseEntity.ok(minerals);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMine(@PathVariable Long id) {
        service.deleteMine(id);
        return ResponseEntity.noContent().build();
    }
}