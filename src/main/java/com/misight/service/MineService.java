package com.misight.service;

import com.misight.model.Mine;
import com.misight.repository.MineRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MineService {

    private final MineRepo mineRepo;

    @Autowired
    public MineService(MineRepo mineRepo) {
        this.mineRepo = mineRepo;
    }

    public Mine addMine(Mine mine) {
        validateMine(mine);
        return mineRepo.save(mine);
    }

    public Optional<Mine> getMineById(Integer mineId) {
        return mineRepo.findById(mineId);
    }

    public Optional<Mine> findById(Integer mineId) {
        return mineRepo.findById(mineId);
    }

    public void delMine(Integer mineId) {
        mineRepo.deleteById(mineId);
    }

    public List<Mine> getAllMines() {
        return mineRepo.findAll();
    }

    public Mine updateMine(Integer mineId, Mine mineDetails) {
        validateMine(mineDetails);
        Optional<Mine> existingMine = mineRepo.findById(mineId);
        if (existingMine.isPresent()) {
            Mine toUpdate = existingMine.get();
            toUpdate.setMineName(mineDetails.getMineName());
            toUpdate.setLocation(mineDetails.getLocation());
            toUpdate.setCompany(mineDetails.getCompany());
            toUpdate.setProvinceId(mineDetails.getProvinceId());
            return mineRepo.save(toUpdate);
        }
        return null;
    }

    private void validateMine(Mine mine) {
        if (mine == null) {
            throw new IllegalArgumentException("Mine cannot be null");
        }
        if (mine.getMineName() == null || mine.getMineName().trim().isEmpty()) {
            throw new IllegalArgumentException("Mine name cannot be empty");
        }
        if (mine.getLocation() == null || mine.getLocation().trim().isEmpty()) {
            throw new IllegalArgumentException("Location cannot be empty");
        }
        if (mine.getCompany() == null || mine.getCompany().trim().isEmpty()) {
            throw new IllegalArgumentException("Company cannot be empty");
        }
    }
}