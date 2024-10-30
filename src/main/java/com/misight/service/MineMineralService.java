package com.misight.service;

import com.misight.model.Mine;
import com.misight.model.MineMineral;
import com.misight.model.Mineral;
import com.misight.repository.MineMineralRepo;
import com.misight.repository.MineRepo;
import com.misight.repository.MineralRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class MineMineralService {
    private final MineMineralRepo mineMineralRepo;
    private final MineRepo mineRepo;
    private final MineralRepo mineralRepo;

    @Autowired
    public MineMineralService(MineMineralRepo mineMineralRepo,
                              MineRepo mineRepo,
                              MineralRepo mineralRepo) {
        this.mineMineralRepo = mineMineralRepo;
        this.mineRepo = mineRepo;
        this.mineralRepo = mineralRepo;
    }

    @Transactional
    public MineMineral addMineMineral(int mineId, int mineralId) {
        Mine mine = mineRepo.findById(mineId)
                .orElseThrow(() -> new RuntimeException("Mine not found with id: " + mineId));

        Mineral mineral = mineralRepo.findById(mineralId)
                .orElseThrow(() -> new RuntimeException("Mineral not found with id: " + mineralId));

        MineMineral mineMineral = new MineMineral(mine, mineral);
        return mineMineralRepo.save(mineMineral);
    }

    @Transactional
    public List<MineMineral> addBulkMineMinerals() {
        List<MineMineral> savedMineMinerals = new ArrayList<>();

        savedMineMinerals.add(addMineMineral(1, 7));
        savedMineMinerals.add(addMineMineral(1, 3));
        savedMineMinerals.add(addMineMineral(2, 7));
        savedMineMinerals.add(addMineMineral(3, 4));
        savedMineMinerals.add(addMineMineral(4, 5));
        savedMineMinerals.add(addMineMineral(5, 3));
        savedMineMinerals.add(addMineMineral(6, 1));
        savedMineMinerals.add(addMineMineral(7, 3));
        savedMineMinerals.add(addMineMineral(8, 1));
        savedMineMinerals.add(addMineMineral(9, 4));
        savedMineMinerals.add(addMineMineral(10, 1));
        savedMineMinerals.add(addMineMineral(11, 4));
        savedMineMinerals.add(addMineMineral(12, 3));
        savedMineMinerals.add(addMineMineral(13, 4));
        savedMineMinerals.add(addMineMineral(14, 2));
        savedMineMinerals.add(addMineMineral(15, 1));

        return savedMineMinerals;
    }

    public List<MineMineral> getAllMineMinerals() {
        return mineMineralRepo.findAll();
    }
}
