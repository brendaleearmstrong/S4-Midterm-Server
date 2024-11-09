package com.misight.service;

import com.misight.model.SafetyData;
import com.misight.model.Mines;
import com.misight.exception.ResourceNotFoundException;
import com.misight.repository.SafetyDataRepo;
import com.misight.repository.MinesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Service
@Transactional
public class SafetyDataService {

    private final SafetyDataRepo safetyDataRepo;
    private final MinesRepo minesRepo;
    private static final Logger logger = LoggerFactory.getLogger(SafetyDataService.class);

    @Autowired
    public SafetyDataService(SafetyDataRepo safetyDataRepo, MinesRepo minesRepo) {
        this.safetyDataRepo = safetyDataRepo;
        this.minesRepo = minesRepo;
    }

    public SafetyData createSafetyData(Long mineId, SafetyData safetyData) {
        try {
            Mines mine = minesRepo.findById(mineId)
                    .orElseThrow(() -> new ResourceNotFoundException("Mine not found with ID: " + mineId));
            safetyData.setMine(mine);
            SafetyData savedData = safetyDataRepo.save(safetyData);
            logger.debug("Successfully saved SafetyData: {}", savedData);
            return savedData;
        } catch (Exception e) {
            logger.error("Error saving SafetyData for Mine ID {}: {}", mineId, e.getMessage());
            throw e;
        }
    }

    public SafetyData getSafetyDataById(Long id) {
        return safetyDataRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Safety data not found with ID: " + id));
    }

    public List<SafetyData> getAllSafetyData() {
        return safetyDataRepo.findAll();
    }

    public List<SafetyData> getSafetyDataByMine(Long mineId) {
        return safetyDataRepo.findByMineId(mineId);
    }

    public SafetyData updateSafetyData(Long id, SafetyData safetyDataDetails) {
        SafetyData safetyData = getSafetyDataById(id);
        safetyData.setDateRecorded(safetyDataDetails.getDateRecorded());
        safetyData.setLostTimeIncidents(safetyDataDetails.getLostTimeIncidents());
        safetyData.setNearMisses(safetyDataDetails.getNearMisses());
        safetyData.setSafetyLevel(safetyDataDetails.getSafetyLevel());
        return safetyDataRepo.save(safetyData);
    }

    public void deleteSafetyData(Long id) {
        if (!safetyDataRepo.existsById(id)) {
            throw new ResourceNotFoundException("Safety data not found with ID: " + id);
        }
        safetyDataRepo.deleteById(id);
    }
}
