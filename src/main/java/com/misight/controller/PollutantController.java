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

    @GetMapping("/{pollutant_id}")
    public Optional<Pollutant> getPollutantById(@PathVariable("pollutant_id") Integer pollutant_id) {
        return pollutantService.getPollutantById(pollutant_id);
    }

    @DeleteMapping("/{pollutant_id}")
    public boolean deletePollutant(@PathVariable("pollutant_id") Integer pollutant_id) {
        if (!pollutantService.findById(pollutant_id).equals(Optional.empty())) {
            pollutantService.delPollutant(pollutant_id);
            return true;
        }
        return false;
    }

    @PutMapping("/{pollutant_id}")
    public Pollutant updatePollutant(@PathVariable("pollutant_id") Integer pollutant_id,
                                     @RequestBody Map<String, String> body) {
        Pollutant currentPollutant = pollutantService.getPollutantById(pollutant_id).get();
        currentPollutant.setPollutant_name(body.get("pollutant_name"));
        currentPollutant.setUnit(body.get("unit"));
        currentPollutant.setDescription(body.get("description"));

        pollutantService.addPollutant(currentPollutant);
        return currentPollutant;
    }
}
