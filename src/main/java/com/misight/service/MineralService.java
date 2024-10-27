package com.misight.service;

import com.misight.model.Mineral;
import com.misight.repository.MineRepo;
import com.misight.repository.MineralRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MineralService {

    private final MineralRepo mineralRepo;

    @Autowired
    public MineralService(MineralRepo mineralRepo){
        this.mineralRepo = mineralRepo;
    }

    public Mineral addMineral(Mineral mineral) {
        return mineralRepo.save(mineral);
    }

    public List<Mineral> getAllMinerals() {
        return mineralRepo.findAll();
    }

    public Optional<Mineral> getMineralById(Integer mineral_id) {
        return mineralRepo.findById(mineral_id);
    }

    public Object findById(Integer mineral_id) {
        return mineralRepo.findById(mineral_id);
    }

    public void delMineral(Integer mineral_id) {
        mineralRepo.deleteById(mineral_id);
    }
}
