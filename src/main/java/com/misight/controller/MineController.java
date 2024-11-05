package com.misight.controller;

import com.misight.model.Mine;
import com.misight.model.Mineral;
import com.misight.service.MineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mines")
public class MineController {

    @Autowired
    private MineService mineService;

    @GetMapping
    public ResponseEntity<List<Mine>> getAllMines() {
        List<Mine> mines = mineService.getAllMines();
        return new ResponseEntity<>(mines, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mine> getMineById(@PathVariable Long id) {
        Mine mine = mineService.getMineById(id);
        return mine != null ? new ResponseEntity<>(mine, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<Mine> createMine(@RequestBody Mine mine) {
        Mine newMine = mineService.createMine(mine);
        return new ResponseEntity<>(newMine, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Mine> updateMine(@PathVariable Long id, @RequestBody Mine updatedMine) {
        Mine mine = mineService.updateMine(id, updatedMine);
        return mine != null ? new ResponseEntity<>(mine, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMine(@PathVariable Long id) {
        mineService.deleteMine(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/search/{mineName}/minerals")
    public ResponseEntity<List<Mineral>> getMineralsByMineName(@PathVariable String mineName) {
        List<Mineral> minerals = mineService.getMineralsByMineName(mineName);
        return minerals != null ? new ResponseEntity<>(minerals, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
