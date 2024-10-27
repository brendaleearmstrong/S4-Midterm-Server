package com.misight.controller;

import com.misight.model.Mine;
import com.misight.service.MineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

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

    @GetMapping("/mines/{mine_id}")
    public Optional<Mine> getMineById(@PathVariable("mine_id") Integer mine_id){
        return mineService.getMineById(mine_id);
    }

    @DeleteMapping("/mines/{mine_id}")
    public boolean deleteMine(@PathVariable("mine_id") Integer mine_id){
        if(!mineService.findById(mine_id).equals(Optional.empty())){
            mineService.delMine(mine_id);
            return true;
        }
        return false;
    }

    @PutMapping("/mines/{mine_id}")
    public Mine updateMine(@PathVariable("mine_id") Integer mine_id, @RequestBody Map<String, String> body){
        Mine currentMine = mineService.getMineById(mine_id).get();
        currentMine.setMine_name(body.get("mine_name"));
        currentMine.setLocation(body.get("location"));
        currentMine.setCompany(body.get("company"));
        currentMine.setProvince_id(Integer.parseInt(body.get("province_id")));

        mineService.addMine(currentMine);
        return currentMine;
    }
}
