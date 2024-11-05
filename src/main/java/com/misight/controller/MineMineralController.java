package com.misight.controller;

import com.misight.model.MineMineral;
import com.misight.service.MineMineralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mine-minerals")
public class MineMineralController {

    @Autowired
    private MineMineralService mineMineralService;

    @GetMapping
    public List<MineMineral> getAllMineMinerals() {
        return mineMineralService.findAll();
    }

    @GetMapping("/{id}")
    public MineMineral getMineMineralById(@PathVariable Long id) {
        return mineMineralService.findById(id);
    }

    @PostMapping
    public MineMineral createMineMineral(@RequestBody MineMineral mineMineral) {
        return mineMineralService.save(mineMineral);
    }

    @DeleteMapping("/{id}")
    public void deleteMineMineral(@PathVariable Long id) {
        mineMineralService.deleteById(id);
    }
}