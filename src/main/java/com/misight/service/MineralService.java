package com.misight.service;

import com.misight.model.Mineral;
import com.misight.repository.MineralRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MineralService {
    @Autowired
    private MineralRepo mineralRepo;

    public List<Mineral> getAllMinerals() { return mineralRepo.findAll(); }
    public Mineral getMineralById(int id) { return mineralRepo.findById(id).orElse(null); }
    public Mineral saveMineral(Mineral mineral) { return mineralRepo.save(mineral); }
    public void deleteMineral(int id) { mineralRepo.deleteById(id); }
}
