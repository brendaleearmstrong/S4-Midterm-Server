package com.misight.service;

import com.misight.model.EnvironmentalData;
import com.misight.repository.EnvironmentalDataRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDate;
import java.util.List;
import com.misight.exception.ResourceNotFoundException;

@Service
@Transactional
public class EnvironmentalDataService {
    private final EnvironmentalDataRepo environmentalDataRepo;

    @Autowired
    public EnvironmentalDataService(EnvironmentalDataRepo environmentalDataRepo) {
        this.environmentalDataRepo = environmentalDataRepo;
    }

    public EnvironmentalData createData(EnvironmentalData data) {
        return environmentalDataRepo.save(data);
    }

    public EnvironmentalData getDataById(Long id) {
        return environmentalDataRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Environmental data not found with id: " + id));
    }

    public List<EnvironmentalData> getAllData() {
        return environmentalDataRepo.findAll();
    }

    public List<EnvironmentalData> getDataByStation(Long stationId) {
        return environmentalDataRepo.findByMonitoringStationId(stationId);
    }

    public List<EnvironmentalData> getDataByDateRange(LocalDate startDate, LocalDate endDate) {
        return environmentalDataRepo.findByDateRecordedBetween(startDate, endDate);
    }

    public List<EnvironmentalData> getDataByStationAndDateRange(Long stationId, LocalDate startDate, LocalDate endDate) {
        return environmentalDataRepo.findByMonitoringStationIdAndDateRecordedBetween(stationId, startDate, endDate);
    }

    public EnvironmentalData updateData(Long id, EnvironmentalData dataDetails) {
        EnvironmentalData data = getDataById(id);
        data.setDateRecorded(dataDetails.getDateRecorded());
        data.setValue(dataDetails.getValue());
        data.setPollutant(dataDetails.getPollutant());
        data.setMonitoringStation(dataDetails.getMonitoringStation());
        return environmentalDataRepo.save(data);
    }

    public void deleteData(Long id) {
        if (!environmentalDataRepo.existsById(id)) {
            throw new ResourceNotFoundException("Environmental data not found with id: " + id);
        }
        environmentalDataRepo.deleteById(id);
    }
}
