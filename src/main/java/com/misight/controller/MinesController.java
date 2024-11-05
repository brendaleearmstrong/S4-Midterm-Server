package com.misight.controller;

import com.misight.model.Mines;
import com.misight.service.MinesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMine(@PathVariable Long id) {
        service.deleteMine(id);
        return ResponseEntity.noContent().build();
    }
}
