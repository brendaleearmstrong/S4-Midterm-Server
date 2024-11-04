package com.misight.service;

import com.misight.model.Mineral;
import com.misight.repository.MineralRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MineralService {

    private final MineralRepo mineralRepo;

    @Autowired
    public MineralService(MineralRepo mineralRepo) {
        this.mineralRepo = mineralRepo;
    }

    public Mineral addMineral(Mineral mineral) {
        return mineralRepo.save(mineral);
    }

    public List<Mineral> getAllMinerals() {
        return mineralRepo.findAll();
    }

    public Optional<Mineral> getMineralById(Integer mineralId) {
        return mineralRepo.findById(mineralId);
    }

    public Optional<Mineral> findById(Integer mineralId) {
        return mineralRepo.findById(mineralId);
    }

    public void delMineral(Integer mineralId) {
        mineralRepo.deleteById(mineralId);
    }
}
