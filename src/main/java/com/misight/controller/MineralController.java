package com.misight.controller;

import com.misight.model.Mineral;
import com.misight.service.MineralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/minerals")
@CrossOrigin(origins = "*")
public class MineralController {

    private final MineralService mineralService;

    @Autowired
    public MineralController(MineralService mineralService) {
        this.mineralService = mineralService;
    }

    @PostMapping
    public ResponseEntity<Mineral> createMineral(@RequestBody Mineral mineral) {
        Mineral addedMineral = mineralService.addMineral(mineral);
        return new ResponseEntity<>(addedMineral, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Mineral>> getMinerals() {
        return ResponseEntity.ok(mineralService.getAllMinerals());
    }

    @GetMapping("/{mineralId}")
    public ResponseEntity<Mineral> getMineralById(@PathVariable Integer mineralId) {
        return mineralService.getMineralById(mineralId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{mineralId}")
    public ResponseEntity<Void> deleteMineral(@PathVariable Integer mineralId) {
        Optional<Mineral> mineral = mineralService.findById(mineralId);
        if (mineral.isPresent()) {
            mineralService.delMineral(mineralId);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{mineralId}")
    public ResponseEntity<Mineral> updateMineral(@PathVariable Integer mineralId,
                                                 @RequestBody Map<String, String> body) {
        return mineralService.getMineralById(mineralId)
                .map(currentMineral -> {
                    currentMineral.setMineralName(body.get("mineralName"));
                    Mineral updatedMineral = mineralService.addMineral(currentMineral);
                    return ResponseEntity.ok(updatedMineral);
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
