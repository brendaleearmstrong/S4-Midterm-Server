package com.misight.controller;

import com.misight.model.Mine;
import com.misight.service.MineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/mines")
@CrossOrigin(origins = "*")
public class MineController {

    private final MineService mineService;

    @Autowired
    public MineController(MineService mineService) {
        this.mineService = mineService;
    }

    @PostMapping
    public ResponseEntity<Mine> createMine(@RequestBody Mine mine) {
        try {
            Mine addedMine = mineService.addMine(mine);
            return new ResponseEntity<>(addedMine, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<List<Mine>> getMines() {
        return ResponseEntity.ok(mineService.getAllMines());
    }

    @GetMapping("/{mineId}")
    public ResponseEntity<Mine> getMineById(@PathVariable Integer mineId) {
        return mineService.getMineById(mineId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{mineId}")
    public ResponseEntity<Void> deleteMine(@PathVariable Integer mineId) {
        if (mineService.findById(mineId).isPresent()) {
            mineService.delMine(mineId);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{mineId}")
    public ResponseEntity<Mine> updateMine(@PathVariable Integer mineId, @RequestBody Mine mine) {
        try {
            Mine updatedMine = mineService.updateMine(mineId, mine);
            if (updatedMine != null) {
                return ResponseEntity.ok(updatedMine);
            }
            return ResponseEntity.notFound().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}