package com.misight.service;

import com.misight.model.SafetyData;
import com.misight.model.Mine;
import com.misight.repository.SafetyDataRepo;
import com.misight.repository.MineRepo;
import com.misight.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class SafetyDataService {
    private final SafetyDataRepo safetyDataRepo;
    private final MineRepo mineRepo;

    @Autowired
    public SafetyDataService(SafetyDataRepo safetyDataRepo, MineRepo mineRepo) {
        this.safetyDataRepo = safetyDataRepo;
        this.mineRepo = mineRepo;
    }

    public SafetyData createSafetyData(Long mineId, SafetyData safetyData) {
        Mine mine = mineRepo.findById(mineId)
                .orElseThrow(() -> new ResourceNotFoundException("Mine not found"));

        safetyData.setMine(mine);
        safetyData.setSafetyLevel(calculateSafetyLevel(
                safetyData.getLostTimeIncidents(),
                safetyData.getNearMisses()
        ));

        return safetyDataRepo.save(safetyData);
    }

    public SafetyData getSafetyDataById(Long id) {
        return safetyDataRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Safety data not found with id: " + id));
    }

    public List<SafetyData> getAllSafetyData() {
        return safetyDataRepo.findAll();
    }

    public List<SafetyData> getSafetyDataByMine(Long mineId) {
        if (!mineRepo.existsById(mineId)) {
            throw new ResourceNotFoundException("Mine not found");
        }
        return safetyDataRepo.findByMineId(mineId);
    }

    public List<SafetyData> getSafetyDataByDateRange(Long mineId, LocalDate startDate, LocalDate endDate) {
        if (!mineRepo.existsById(mineId)) {
            throw new ResourceNotFoundException("Mine not found");
        }
        return safetyDataRepo.findByMineIdAndDateRecordedBetween(mineId, startDate, endDate);
    }

    public SafetyData updateSafetyData(Long id, SafetyData safetyDataDetails) {
        SafetyData safetyData = getSafetyDataById(id);

        safetyData.setDateRecorded(safetyDataDetails.getDateRecorded());
        safetyData.setLostTimeIncidents(safetyDataDetails.getLostTimeIncidents());
        safetyData.setNearMisses(safetyDataDetails.getNearMisses());
        safetyData.setSafetyLevel(calculateSafetyLevel(
                safetyDataDetails.getLostTimeIncidents(),
                safetyDataDetails.getNearMisses()
        ));

        return safetyDataRepo.save(safetyData);
    }

    public void deleteSafetyData(Long id) {
        if (!safetyDataRepo.existsById(id)) {
            throw new ResourceNotFoundException("Safety data not found with id: " + id);
        }
        safetyDataRepo.deleteById(id);
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
