package com.misight.controller;

import com.misight.model.Mine;
import com.misight.service.MineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mines")
public class MineController {
    @Autowired
    private MineService mineService;

    @GetMapping
    public List<Mine> getAllMines() { return mineService.getAllMines(); }

    @GetMapping("/{id}")
    public Mine getMineById(@PathVariable int id) { return mineService.getMineById(id); }

    @PostMapping
    public Mine createMine(@RequestBody Mine mine) { return mineService.saveMine(mine); }

    @DeleteMapping("/{id}")
    public void deleteMine(@PathVariable int id) { mineService.deleteMine(id); }
}