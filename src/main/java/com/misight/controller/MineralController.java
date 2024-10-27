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

public class MineralController {

    private final MineralService mineralService;

    @Autowired
    public MineralController(MineralService mineralService){
        this.mineralService = mineralService;
    }

    @PostMapping("/minerals")
    public ResponseEntity<Mineral> createMine(@RequestBody Mineral mineral){
        Mineral addedMineral = mineralService.addMineral(mineral);
        return new ResponseEntity<>(addedMineral, HttpStatus.CREATED);
    }

    @GetMapping("/minerals")
    public List<Mineral> getMinerals(){
        return mineralService.getAllMinerals();
    }

    @GetMapping("/minerals/{mineral_id}")
    public Optional<Mineral> getMineralById(@PathVariable("mineral_id") Integer mineral_id){
        return mineralService.getMineralById(mineral_id);
    }

    @DeleteMapping("/minerals/{mineral_id}")
    public boolean deleteMineral(@PathVariable("mineral_id") Integer mineral_id){
        if(!mineralService.findById(mineral_id).equals(Optional.empty())){
            mineralService.delMineral(mineral_id);
            return true;
        }
        return false;
    }

    @PutMapping("/minerals/{mineral_id}")
    public Mineral updateMineral(@PathVariable("mineral_id") Integer mineral_id, @RequestBody Map<String, String> body){
        Mineral currentMineral = mineralService.getMineralById(mineral_id).get();
        currentMineral.setMineral_name(body.get("mineral_name"));

        mineralService.addMineral(currentMineral);
        return currentMineral;
    }
}
