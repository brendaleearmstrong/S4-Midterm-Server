package com.misight.service;

import com.misight.model.Mine;
import com.misight.model.Mineral;
import com.misight.model.MineMineral;
import com.misight.repository.MineMineralRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MineMineralService {

    private final MineService mineService;
    private final MineralService mineralService;
    private final MineMineralRepo mineMineralRepo;

    @Autowired
    public MineMineralService(MineService mineService, MineralService mineralService, MineMineralRepo mineMineralRepo) {
        this.mineService = mineService;
        this.mineralService = mineralService;
        this.mineMineralRepo = mineMineralRepo;
    }

    public MineMineral addMineMineral(int mineId, int mineralId) {
        Optional<Mine> mineOptional = mineService.getMineById(mineId);
        Optional<Mineral> mineralOptional = mineralService.getMineralById(mineralId);

        if (mineOptional.isEmpty()) {
            throw new IllegalArgumentException("Mine not found");
        }

        if (mineralOptional.isEmpty()) {
            throw new IllegalArgumentException("Mineral not found");
        }

        Mine mine = mineOptional.get();
        Mineral mineral = mineralOptional.get();

        // Check if association already exists
        if (mineMineralRepo.findByMineAndMineral(mine, mineral).isPresent()) {
            throw new DataIntegrityViolationException("This mine-mineral combination already exists.");
        }

        // Create and save new association
        MineMineral mineMineral = new MineMineral();
        mineMineral.setMine(mine);
        mineMineral.setMineral(mineral);
        return mineMineralRepo.save(mineMineral);
    }

    public List<MineMineral> getAllMineMinerals() {
        return mineMineralRepo.findAll();
    }
}
