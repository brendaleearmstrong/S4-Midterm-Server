package com.misight.controller;

import com.misight.model.Mines;
import com.misight.model.Minerals;
import com.misight.service.MinesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/api/mines")
public class MinesController {

    @Autowired
    private MinesService minesService;

    @PostMapping
    public Mines createMine(@RequestBody Mines mine) {
        return minesService.createMine(mine);
    }

    @GetMapping("/{id}")
    public Optional<Mines> getMineById(@PathVariable Long id) {
        return minesService.getMineById(id);
    }

    @GetMapping
    public Iterable<Mines> getAllMines() {
        return minesService.getAllMines();
    }

    @PutMapping("/{id}")
    public Mines updateMine(@PathVariable Long id, @RequestBody Mines mineDetails) {
        return minesService.updateMine(id, mineDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteMine(@PathVariable Long id) {
        minesService.deleteMine(id);
    }

    @PutMapping("/{id}/minerals")
    public Mines updateMineMinerals(@PathVariable Long id, @RequestBody Set<Minerals> minerals) {
        return minesService.updateMineMinerals(id, minerals);
    }
}
