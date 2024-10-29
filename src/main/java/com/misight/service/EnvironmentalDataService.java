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

    public Optional<EnvironmentalData> getEnvironmentalDataById(Integer data_id) {
        return environmentalDataRepo.findById(data_id);
    }

    public List<EnvironmentalData> getEnvironmentalDataByDate(LocalDate date) {
        return environmentalDataRepo.findByDate(date);
    }

    public List<EnvironmentalData> getEnvironmentalDataByStation(Integer station_id) {
        return environmentalDataRepo.findByStationId(station_id);
    }

    public List<EnvironmentalData> getEnvironmentalDataByPollutant(Integer pollutant_id) {
        return environmentalDataRepo.findByPollutantId(pollutant_id);
    }

    public void deleteEnvironmentalData(Integer data_id) {
        environmentalDataRepo.deleteById(data_id);
    }
}