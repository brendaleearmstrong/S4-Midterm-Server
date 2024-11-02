package com.misight.service;

import com.misight.model.EnvironmentalData;
import com.misight.repository.EnvironmentalDataRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class EnvironmentalDataService {

    private final EnvironmentalDataRepo environmentalDataRepo;

    @Autowired
    public EnvironmentalDataService(EnvironmentalDataRepo environmentalDataRepo) {
        this.environmentalDataRepo = environmentalDataRepo;
    }

    public List<EnvironmentalData> getAllEnvironmentalData() {
        return environmentalDataRepo.findAll();
    }

    public Optional<EnvironmentalData> getEnvironmentalDataById(Integer dataId) {
        return environmentalDataRepo.findById(dataId);
    }

    public EnvironmentalData createEnvironmentalData(EnvironmentalData data) {
        return environmentalDataRepo.save(data);
    }

    public Optional<EnvironmentalData> updateEnvironmentalData(Integer id, EnvironmentalData data) {
        if (environmentalDataRepo.existsById(id)) {
            data.setDataId(id);
            return Optional.of(environmentalDataRepo.save(data));
        }
        return Optional.empty();
    }

    public List<EnvironmentalData> getEnvironmentalDataByDate(LocalDate date) {
        return environmentalDataRepo.findByDate(date);
    }

    public List<EnvironmentalData> getEnvironmentalDataByStation(Integer stationId) {
        return environmentalDataRepo.findByStationStationId(stationId);
    }

    public List<EnvironmentalData> getEnvironmentalDataByPollutant(Integer pollutantId) {
        return environmentalDataRepo.findByPollutantPollutantId(pollutantId);
    }

    public boolean deleteEnvironmentalData(Integer id) {
        if (environmentalDataRepo.existsById(id)) {
            environmentalDataRepo.deleteById(id);
            return true;
        }
        return false;
    }
}