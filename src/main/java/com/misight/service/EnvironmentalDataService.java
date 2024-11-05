package com.misight.service;

import com.misight.model.EnvironmentalData;
import com.misight.repository.EnvironmentalDataRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class EnvironmentalDataService {

    @Autowired
    private EnvironmentalDataRepo repo;

    public List<EnvironmentalData> getAllData() {
        return repo.findAll();
    }

    public EnvironmentalData getDataById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public List<EnvironmentalData> getDataByStation(Long stationId) {
        return repo.findByMonitoringStationId(stationId);
    }

    public List<EnvironmentalData> getDataByDateRange(LocalDate start, LocalDate end) {
        return repo.findByDateRecordedBetween(start, end);
    }

    public EnvironmentalData createData(EnvironmentalData data) {
        return repo.save(data);
    }

    public EnvironmentalData updateData(Long id, EnvironmentalData data) {
        data.setId(id);
        return repo.save(data);
    }

    public void deleteData(Long id) {
        repo.deleteById(id);
    }
}
