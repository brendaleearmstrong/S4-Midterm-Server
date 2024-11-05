package com.misight.controller;

import com.misight.model.Mine;
import com.misight.service.MineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/mines")
@CrossOrigin(origins = "*")
public class MineController {
    private final MineService mineService;

    @Autowired
    public MineController(MineService mineService) {
        this.mineService = mineService;
    }

    @GetMapping
    public ResponseEntity<List<Mine>> getAllMines() {
        return ResponseEntity.ok(mineService.getAllMines());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mine> getMineById(@PathVariable Long id) {
        return ResponseEntity.ok(mineService.getMineById(id));
    }

    @GetMapping("/{id}/minerals")
    public ResponseEntity<Mine> getMineWithMinerals(@PathVariable Long id) {
        return ResponseEntity.ok(mineService.getMineWithMinerals(id));
    }

    @GetMapping("/company/{company}")
    public ResponseEntity<List<Mine>> getMinesByCompany(@PathVariable String company) {
        return ResponseEntity.ok(mineService.getMinesByCompany(company));
    }

    @GetMapping("/province/{provinceId}")
    public ResponseEntity<List<Mine>> getMinesByProvince(@PathVariable Long provinceId) {
        return ResponseEntity.ok(mineService.getMinesByProvince(provinceId));
    }

    @GetMapping("/mineral/{mineralId}")
    public ResponseEntity<List<Mine>> getMinesByMineral(@PathVariable Long mineralId) {
        return ResponseEntity.ok(mineService.getMinesByMineral(mineralId));
    }

    @GetMapping("/search")
    public ResponseEntity<List<Mine>> searchMinesByName(@RequestParam String name) {
        return ResponseEntity.ok(mineService.searchMinesByName(name));
    }

    @PostMapping
    public ResponseEntity<Mine> createMine(@RequestBody Mine mine) {
        return new ResponseEntity<>(mineService.createMine(mine), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Mine> updateMine(@PathVariable Long id, @RequestBody Mine mine) {
        return ResponseEntity.ok(mineService.updateMine(id, mine));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMine(@PathVariable Long id) {
        mineService.deleteMine(id);
        return ResponseEntity.noContent().build();
    }
}