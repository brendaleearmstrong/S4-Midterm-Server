package com.misight.controller;

import com.misight.model.MineMineral;
import com.misight.service.MineMineralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/mine-minerals")
public class MineMineralController {
    private final MineMineralService mineMineralService;

    @Autowired
    public MineMineralController(MineMineralService mineMineralService) {
        this.mineMineralService = mineMineralService;
    }

    @PostMapping("/bulk")
    public ResponseEntity<List<MineMineral>> addBulkMineMinerals() {
        List<MineMineral> savedMineMinerals = mineMineralService.addBulkMineMinerals();
        return ResponseEntity.ok(savedMineMinerals);
    }

    @PostMapping
    public ResponseEntity<MineMineral> addMineMineral(@RequestParam int mineId, @RequestParam int mineralId) {
        MineMineral savedMineMineral = mineMineralService.addMineMineral(mineId, mineralId);
        return ResponseEntity.ok(savedMineMineral);
    }

    @GetMapping
    public ResponseEntity<List<MineMineral>> getAllMineMinerals() {
        List<MineMineral> mineMinerals = mineMineralService.getAllMineMinerals();
        return ResponseEntity.ok(mineMinerals);
    }
}