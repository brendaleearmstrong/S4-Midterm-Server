package com.misight.service;

import com.misight.model.SafetyData;
import com.misight.repository.SafetyDataRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SafetyDataService {

    private final SafetyDataRepo safetyDataRepo;

    @Autowired
    public SafetyDataService(SafetyDataRepo safetyDataRepo) {
        this.safetyDataRepo = safetyDataRepo;
    }

    public List<SafetyData> getAllSafetyData() {
        return safetyDataRepo.findAll();
    }

    public Optional<SafetyData> getSafetyDataById(int id) {
        return safetyDataRepo.findById(id);
    }

    public SafetyData addSafetyData(int mineId, int lostTimeIncidents, int nearMisses) {
        SafetyData safetyData = new SafetyData();
        safetyData.setMineId(mineId);
        safetyData.setLostTimeIncidents(lostTimeIncidents);
        safetyData.setNearMisses(nearMisses);
        safetyData.setSafetyLevel(calculateSafetyLevel(lostTimeIncidents, nearMisses));
        return safetyDataRepo.save(safetyData);
    }

    public boolean deleteSafetyData(int id) {
        if (safetyDataRepo.existsById(id)) {
            safetyDataRepo.deleteById(id);
            return true;
        }
        return false;
    }

    private SafetyData.SafetyLevel calculateSafetyLevel(int lostTimeIncidents, int nearMisses) {
        if (lostTimeIncidents > 0) {
            return SafetyData.SafetyLevel.NEEDS_IMPROVEMENT;
        } else if (nearMisses > 2) {
            return SafetyData.SafetyLevel.NEEDS_IMPROVEMENT;
        } else if (nearMisses > 0) {
            return SafetyData.SafetyLevel.FAIR;
        } else {
            return SafetyData.SafetyLevel.GOOD;
        }
    }
}
