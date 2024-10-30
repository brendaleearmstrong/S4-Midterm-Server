package com.misight.controller;

import com.misight.model.Mine;
import com.misight.service.MineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mines") // Ensure this matches the intended endpoint exactly
public class MineController {

    @Autowired
    private MineService mineService;

    // Endpoint to retrieve all mines
    @GetMapping
    public List<Mine> getAllMines() {
        return mineService.getAllMines();
    }

    // Endpoint to retrieve a mine by ID
    @GetMapping("/{id}")
    public Mine getMineById(@PathVariable int id) {
        return mineService.getMineById(id).orElse(null);
    }

    // Endpoint to create a new mine
    @PostMapping
    public Mine createMine(@RequestBody Mine mine) {
        return mineService.saveMine(mine);
    }

    // Endpoint to delete a mine by ID
    @DeleteMapping("/{id}")
    public void deleteMine(@PathVariable int id) {
        mineService.deleteMine(id);
    }
}


