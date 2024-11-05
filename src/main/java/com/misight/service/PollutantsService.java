package com.misight.service;

import com.misight.model.Pollutants;
import com.misight.repository.PollutantsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PollutantsService {

    @Autowired
    private PollutantsRepo repo;

    public List<Pollutants> getAllPollutants() {
        return repo.findAll();
    }

    public Pollutants getPollutantById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public List<Pollutants> getPollutantsByName(String name) {
        return repo.findByNameIgnoreCase(name);
    }

    public List<Pollutants> getPollutantsByType(String type) {
        return repo.findByType(type);
    }

    public Pollutants createPollutant(Pollutants pollutant) {
        return repo.save(pollutant);
    }

    public Pollutants updatePollutant(Long id, Pollutants updatedPollutant) {
        Optional<Pollutants> existingPollutant = repo.findById(id);
        if (existingPollutant.isPresent()) {
            updatedPollutant.setId(id);
            return repo.save(updatedPollutant);
        } else {
            return null;
        }
    }

    public void deletePollutant(Long id) {
        repo.deleteById(id);
    }
}
