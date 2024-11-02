package com.misight.service;

import com.misight.model.Pollutant;
import com.misight.repository.PollutantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PollutantService {
    private final PollutantRepo pollutantRepo;

    @Autowired
    public PollutantService(PollutantRepo pollutantRepo) {
        this.pollutantRepo = pollutantRepo;
    }

    public Pollutant addPollutant(Pollutant pollutant) {
        return pollutantRepo.save(pollutant);
    }

    public List<Pollutant> getAllPollutants() {
        return pollutantRepo.findAll();
    }

    public Optional<Pollutant> getPollutantById(Integer pollutant_id) {
        return pollutantRepo.findById(pollutant_id);
    }

    public Optional<Pollutant> findById(Integer pollutant_id) {  // Added this method to match usage in controller
        return pollutantRepo.findById(pollutant_id);
    }

    public void delPollutant(Integer pollutant_id) {
        pollutantRepo.deleteById(pollutant_id);
    }
}
