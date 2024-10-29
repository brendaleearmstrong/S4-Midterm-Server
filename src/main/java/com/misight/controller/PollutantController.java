package com.misight.controller;

import com.misight.model.Pollutant;
import com.misight.service.PollutantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pollutants")
public class PollutantController {

    @Autowired
    private PollutantService pollutantService;

    @PostMapping
    public ResponseEntity<Pollutant> addPollutant(@RequestBody Pollutant pollutant) {
        return new ResponseEntity<>(pollutantService.addPollutant(pollutant), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Pollutant>> getAllPollutants() {
        return new ResponseEntity<>(pollutantService.getAllPollutants(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pollutant> getPollutantById(@PathVariable int id) {
        return pollutantService.getPollutantById(id)
                .map(pollutant -> new ResponseEntity<>(pollutant, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pollutant> updatePollutant(@PathVariable int id, @RequestBody Pollutant pollutant) {
        return new ResponseEntity<>(pollutantService.updatePollutant(id, pollutant), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePollutant(@PathVariable int id) {
        pollutantService.deletePollutant(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}