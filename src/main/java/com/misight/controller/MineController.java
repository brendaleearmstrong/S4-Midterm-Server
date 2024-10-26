package com.misight.controller;

import com.misight.model.Mine;
import com.misight.service.MineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class MineController {

    private final MineService mineService;

    @Autowired
    public MineController(MineService mineService){
        this.mineService = mineService;
    }

    @PostMapping("/mines")
    public ResponseEntity<Mine> createMine(@RequestBody Mine mine){
        Mine addedMine = mineService.addMine(mine);
        return new ResponseEntity<>(addedMine, HttpStatus.CREATED);
    }

    @GetMapping("/mines")
    public List<Mine> getMine(){
        return mineService.getAllMines();
    }
}
