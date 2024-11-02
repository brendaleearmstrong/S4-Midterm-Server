package com.misight.controller;

import com.misight.model.Pollutant;
import com.misight.service.PollutantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/pollutants")
public class PollutantController {

    private final PollutantService pollutantService;

    @Autowired
    public PollutantController(PollutantService pollutantService) {
        this.pollutantService = pollutantService;
    }

    @PostMapping
    public ResponseEntity<Pollutant> createPollutant(@RequestBody Pollutant pollutant) {
        Pollutant addedPollutant = pollutantService.addPollutant(pollutant);
        return new ResponseEntity<>(addedPollutant, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Pollutant> getPollutants() {
        return pollutantService.getAllPollutants();
    }

    @GetMapping("/{pollutantId}")
    public Optional<Pollutant> getPollutantById(@PathVariable("pollutantId") Integer pollutantId) {
        return pollutantService.getPollutantById(pollutantId);
    }

    @DeleteMapping("/{pollutantId}")
    public boolean deletePollutant(@PathVariable("pollutantId") Integer pollutantId) {
        if (!pollutantService.findById(pollutantId).equals(Optional.empty())) {
            pollutantService.delPollutant(pollutantId);
            return true;
        }
        return false;
    }

    @PutMapping("/{pollutantId}")
    public Pollutant updatePollutant(@PathVariable("pollutantId") Integer pollutantId,
                                     @RequestBody Map<String, String> body) {
        Pollutant currentPollutant = pollutantService.getPollutantById(pollutantId).get();
        currentPollutant.setPollutantName(body.get("pollutantName"));
        currentPollutant.setUnit(body.get("unit"));
        currentPollutant.setDescription(body.get("description"));

        pollutantService.addPollutant(currentPollutant);
        return currentPollutant;
    }
}