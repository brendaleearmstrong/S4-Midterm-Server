package com.misight.service;

import com.misight.exception.ResourceNotFoundException;
import com.misight.model.Pollutant;
import com.misight.repository.PollutantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PollutantService {

    private final PollutantRepo pollutantRepo;

    @Autowired
    public PollutantService(PollutantRepo pollutantRepo) {
        this.pollutantRepo = pollutantRepo;
    }

    public List<Pollutant> getAllPollutants() {
        return pollutantRepo.findAll();
    }

    public Pollutant getPollutantById(Long id) {
        return pollutantRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pollutant not found with id: " + id));
    }

    public Pollutant createPollutant(Pollutant pollutant) {
        if (pollutantRepo.existsByNameIgnoreCase(pollutant.getName())) {
            throw new IllegalArgumentException("Pollutant with this name already exists");
        }
        return pollutantRepo.save(pollutant);
    }

    public Pollutant updatePollutant(Long id, Pollutant pollutantDetails) {
        Pollutant pollutant = getPollutantById(id);
        pollutant.setName(pollutantDetails.getName());
        pollutant.setDescription(pollutantDetails.getDescription());
        return pollutantRepo.save(pollutant);
    }

    public void deletePollutant(Long id) {
        if (!pollutantRepo.existsById(id)) {
            throw new ResourceNotFoundException("Pollutant not found with id: " + id);
        }
        pollutantRepo.deleteById(id);
    }
}