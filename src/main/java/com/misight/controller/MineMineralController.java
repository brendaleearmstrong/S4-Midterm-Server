package com.misight.controller;

import com.misight.model.MineMineral;
import com.misight.service.MineMineralService;
import com.misight.service.MineService;
import com.misight.service.MineralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mine-minerals")
public class MineMineralController {
    private final MineMineralService mineMineralService;
    private final MineService mineService;
    private final MineralService mineralService;

    @Autowired
    public MineMineralController(
            MineMineralService mineMineralService,
            MineService mineService,
            MineralService mineralService) {
        this.mineMineralService = mineMineralService;
        this.mineService = mineService;
        this.mineralService = mineralService;
    }

    @PostMapping
    public ResponseEntity<?> addMineMineral(@RequestParam int mineId, @RequestParam int mineralId) {
        try {
            MineMineral mineMineral = mineMineralService.addMineMineral(mineId, mineralId);
            return ResponseEntity.ok(mineMineral);
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Duplicate entry: This mine-mineral combination already exists.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("An error occurred while adding the mine-mineral combination.");
        }
    }

    @GetMapping
    public ResponseEntity<List<MineMineral>> getAllMineMinerals() {
        return ResponseEntity.ok(mineMineralService.getAllMineMinerals());
    }
}
