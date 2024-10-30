package com.misight.service;

import com.misight.model.Mine;
import com.misight.repository.MineRepo;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@Transactional
public class MineServiceImpl implements MineService {

    @Autowired
    private MineRepo mineRepo;

    @Override
    public List<Mine> getAllMines() {
        return mineRepo.findAll();
    }

    @Override
    public Optional<Mine> getMineById(int id) {
        return mineRepo.findById(id);
    }

    @Override
    public Mine saveMine(Mine mine) {
        validateMine(mine);
        return mineRepo.save(mine);
    }

    @Override
    public Optional<Mine> updateMine(int id, Mine mineDetails) {
        validateMine(mineDetails);
        return mineRepo.findById(id)
                .map(existingMine -> {
                    existingMine.setMineName(mineDetails.getMineName());
                    existingMine.setLocation(mineDetails.getLocation());
                    existingMine.setCompany(mineDetails.getCompany());
                    existingMine.setProvince(mineDetails.getProvince());
                    return mineRepo.save(existingMine);
                });
    }

    @Override
    public Optional<Mine> patchMine(int id, Map<String, Object> updates) {
        return mineRepo.findById(id)
                .map(existingMine -> {
                    updates.forEach((key, value) -> {
                        switch (key) {
                            case "mineName":
                                existingMine.setMineName((String) value);
                                break;
                            case "location":
                                existingMine.setLocation((String) value);
                                break;
                            case "company":
                                existingMine.setCompany((String) value);
                                break;
                        }
                    });
                    validateMine(existingMine);
                    return mineRepo.save(existingMine);
                });
    }

    @Override
    public boolean deleteMine(int id) {
        return mineRepo.findById(id)
                .map(mine -> {
                    mineRepo.delete(mine);
                    return true;
                })
                .orElse(false);
    }

    private void validateMine(Mine mine) {
        if (mine == null) {
            throw new ValidationException("Mine cannot be null");
        }
        if (mine.getMineName() == null || mine.getMineName().trim().isEmpty()) {
            throw new ValidationException("Mine name cannot be empty");
        }
        if (mine.getLocation() == null || mine.getLocation().trim().isEmpty()) {
            throw new ValidationException("Location cannot be empty");
        }
        if (mine.getCompany() == null || mine.getCompany().trim().isEmpty()) {
            throw new ValidationException("Company cannot be empty");
        }
        if (mine.getProvince() == null) {
            throw new ValidationException("Province cannot be null");
        }
    }
}