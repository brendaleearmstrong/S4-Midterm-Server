package com.misight.service;

import com.misight.model.Pollutant;
import com.misight.repository.PollutantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PollutantService {

    @Autowired
    private PollutantRepo pollutantRepo;

    public Pollutant addPollutant(Pollutant pollutant) {
        return pollutantRepo.save(pollutant);
    }

    public List<Pollutant> getAllPollutants() {
        return pollutantRepo.findAll();
    }

    public Optional<Pollutant> getPollutantById(int id) {
        return pollutantRepo.findById(id);
    }

    public Pollutant updatePollutant(int id, Pollutant updatedPollutant) {
        return pollutantRepo.findById(id).map(pollutant -> {
            pollutant.setPollutantName(updatedPollutant.getPollutantName());
            pollutant.setUnit(updatedPollutant.getUnit());
            pollutant.setDescription(updatedPollutant.getDescription());
            return pollutantRepo.save(pollutant);
        }).orElseThrow(() -> new RuntimeException("Pollutant not found"));
    }

    public void deletePollutant(int id) {
        pollutantRepo.deleteById(id);
    }
}