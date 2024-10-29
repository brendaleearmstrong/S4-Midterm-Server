package com.misight.service;

import com.misight.model.SafetyData;
import com.misight.repository.SafetyDataRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class SafetyDataService {

    private final SafetyDataRepo safetyRepo;

    @Autowired
    public SafetyDataService(SafetyDataRepo safetyRepo) {
        this.safetyRepo = safetyRepo;
    }

    public SafetyData addSafetyData(SafetyData safetyData) {
        return safetyRepo.save(safetyData);
    }

    public List<SafetyData> getAllSafetyData() {
        return safetyRepo.findAll();
    }

    public Optional<SafetyData> getSafetyDataById(Integer safety_id) {
        return safetyRepo.findById(safety_id);
    }

    public void deleteSafetyData(Integer safety_id) {
        safetyRepo.deleteById(safety_id);
    }
}
