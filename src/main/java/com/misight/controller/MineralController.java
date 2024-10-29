package com.misight.controller;

import com.misight.model.Mineral;
import com.misight.service.MineralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/minerals")
public class MineralController {
    @Autowired
    private MineralService mineralService;

    @GetMapping
    public List<Mineral> getAllMinerals() { return mineralService.getAllMinerals(); }

    @GetMapping("/{id}")
    public Mineral getMineralById(@PathVariable int id) { return mineralService.getMineralById(id); }

    @PostMapping
    public Mineral createMineral(@RequestBody Mineral mineral) { return mineralService.saveMineral(mineral); }

    @DeleteMapping("/{id}")
    public void deleteMineral(@PathVariable int id) { mineralService.deleteMineral(id); }
}

