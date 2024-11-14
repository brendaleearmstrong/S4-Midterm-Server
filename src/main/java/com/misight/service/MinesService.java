package com.misight.service;

import com.misight.model.Mines;
import com.misight.repository.MinesRepo;
import com.misight.repository.MineralsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional
public class MinesService {
    private final MinesRepo minesRepo;
    private final MineralsRepo mineralsRepo;

    @Autowired
    public MinesService(MinesRepo minesRepo, MineralsRepo mineralsRepo) {
        this.minesRepo = minesRepo;
        this.mineralsRepo = mineralsRepo;
    }

    public List<Mines> getAllMines() {
        return minesRepo.findAll();
    }

    public List<Mines> getAllMinesWithMinerals() {
        return minesRepo.findAllWithMinerals();
    }

    public List<Mines> getMinesWithMineral(Long mineralId) {
        return minesRepo.findByMineralId(mineralId);
    }

    public Optional<Mines> getMineById(Long id) {
        return minesRepo.findByIdWithMinerals(id);
    }

    public Mines createMine(Mines mine) {
        return minesRepo.save(mine);
    }

    public Optional<Mines> updateMine(Long id, Mines mineDetails) {
        return minesRepo.findById(id)
                .map(existingMine -> {
                    existingMine.setName(mineDetails.getName());
                    existingMine.setCompany(mineDetails.getCompany());
                    existingMine.setLocation(mineDetails.getLocation());
                    existingMine.setProvince(mineDetails.getProvince());
                    return minesRepo.save(existingMine);
                });
    }

    public Optional<Mines> partialUpdateMine(Long id, Map<String, Object> updates) {
        return minesRepo.findById(id)
                .map(existingMine -> {
                    updates.forEach((key, value) -> {
                        switch (key) {
                            case "name":
                                existingMine.setName((String) value);
                                break;
                            case "company":
                                existingMine.setCompany((String) value);
                                break;
                            case "location":
                                existingMine.setLocation((String) value);
                                break;
                            case "province":
                                break;
                        }
                    });
                    return minesRepo.save(existingMine);
                });
    }

    public boolean deleteMine(Long id) {
        return minesRepo.findById(id)
                .map(mine -> {
                    minesRepo.delete(mine);
                    return true;
                })
                .orElse(false);
    }
}
