package com.misight.service;

import com.misight.model.Mineral;
import com.misight.model.Mine;
import com.misight.repository.MineralRepo;
import com.misight.repository.MineRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MineralService {

    @Autowired
    private MineralRepo mineralRepo;

    @Autowired
    private MineRepo mineRepo;

    public List<Mineral> getAllMinerals() {
        return mineralRepo.findAll();
    }

    public Mineral getMineralById(Long id) {
        return mineralRepo.findById(id).orElse(null);
    }

    public Mineral createMineral(Mineral mineral) {
        return mineralRepo.save(mineral);
    }

    public Mineral updateMineral(Long id, Mineral updatedMineral) {
        Mineral mineral = getMineralById(id);
        if (mineral != null) {
            mineral.setName(updatedMineral.getName());
            mineral.setType(updatedMineral.getType());
            mineral.setDensity(updatedMineral.getDensity());
            return mineralRepo.save(mineral);
        }
        return null;
    }

    public void deleteMineral(Long id) {
        mineralRepo.deleteById(id);
    }

    public List<Mine> getMinesByMineralName(String mineralName) {
        Mineral mineral = mineralRepo.findByName(mineralName).orElse(null);
        return mineral != null ? new ArrayList<>(mineral.getMines()) : null;
    }
}
