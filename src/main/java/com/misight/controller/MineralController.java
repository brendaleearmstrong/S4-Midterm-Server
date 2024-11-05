package com.misight.controller;

import com.misight.model.Mineral;
import com.misight.model.Mine;
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
    public ResponseEntity<List<Mineral>> getAllMinerals() {
        List<Mineral> minerals = mineralService.getAllMinerals();
        return new ResponseEntity<>(minerals, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mineral> getMineralById(@PathVariable Long id) {
        Mineral mineral = mineralService.getMineralById(id);
        return mineral != null ? new ResponseEntity<>(mineral, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<Mineral> createMineral(@RequestBody Mineral mineral) {
        Mineral newMineral = mineralService.createMineral(mineral);
        return new ResponseEntity<>(newMineral, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Mineral> updateMineral(@PathVariable Long id, @RequestBody Mineral updatedMineral) {
        Mineral mineral = mineralService.updateMineral(id, updatedMineral);
        return mineral != null ? new ResponseEntity<>(mineral, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMineral(@PathVariable Long id) {
        mineralService.deleteMineral(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/search/{mineralName}/mines")
    public ResponseEntity<List<Mine>> getMinesByMineralName(@PathVariable String mineralName) {
        List<Mine> mines = mineralService.getMinesByMineralName(mineralName);
        return mines != null ? new ResponseEntity<>(mines, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
