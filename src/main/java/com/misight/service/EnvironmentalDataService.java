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

    public EnvironmentalData addEnvironmentalData(EnvironmentalData data) {
        return environmentalDataRepo.save(data);
    }

    public List<EnvironmentalData> getAllEnvironmentalData() {
        return environmentalDataRepo.findAll();
    }

    public Optional<EnvironmentalData> getEnvironmentalDataById(Integer dataId) {
        return environmentalDataRepo.findById(dataId);
    }

    public List<EnvironmentalData> getEnvironmentalDataByDate(LocalDate date) {
        return environmentalDataRepo.findByDateRecorded(date);
    }

    public List<EnvironmentalData> getEnvironmentalDataByStation(Integer stationId) {
        return environmentalDataRepo.findByMonitoringStation_StationId(stationId);
    }

    public List<EnvironmentalData> getEnvironmentalDataByPollutant(Integer pollutantId) {
        return environmentalDataRepo.findByPollutant_PollutantId(pollutantId);
    }

    public void deleteEnvironmentalData(Integer dataId) {
        environmentalDataRepo.deleteById(dataId);
    }
}