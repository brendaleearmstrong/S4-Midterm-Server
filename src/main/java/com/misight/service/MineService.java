package com.misight.service;

import com.misight.model.Mine;
import com.misight.model.Mineral;
import com.misight.repository.MineRepo;
import com.misight.repository.MineralRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MineService {

    @Autowired
    private MineRepo mineRepo;

    @Autowired
    private MineralRepo mineralRepo;

    public List<Mine> getAllMines() {
        return mineRepo.findAll();
    }

    public Mine getMineById(Long id) {
        return mineRepo.findById(id).orElse(null);
    }

    public Mine createMine(Mine mine) {
        return mineRepo.save(mine);
    }

    public Mine updateMine(Long id, Mine updatedMine) {
        Mine mine = getMineById(id);
        if (mine != null) {
            mine.setName(updatedMine.getName());
            mine.setProvince(updatedMine.getProvince());
            return mineRepo.save(mine);
        }
        return null;
    }

    public void deleteMine(Long id) {
        mineRepo.deleteById(id);
    }

    public List<Mineral> getMineralsByMineName(String mineName) {
        Mine mine = mineRepo.findByName(mineName).orElse(null);
        return mine != null ? new ArrayList<>(mine.getMinerals()) : null;
    }
}


