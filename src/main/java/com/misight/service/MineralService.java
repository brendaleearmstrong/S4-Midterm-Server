package com.misight.service;

import com.misight.model.Mineral;
import com.misight.repository.MineralRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MineralService {
    @Autowired
    private MineralRepo mineralRepo;

    public List<Mineral> getAllMinerals() {
        return mineralRepo.findAll();
    }

    // Adjusted to return Optional<Mineral>
    public Optional<Mineral> getMineralById(int id) {
        return mineralRepo.findById(id);
    }

    public Mineral saveMineral(Mineral mineral) {
        return mineralRepo.save(mineral);
    }

    public void deleteMineral(int id) {
        mineralRepo.deleteById(id);
    }
}

