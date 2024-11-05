package com.misight.service;

import com.misight.exception.ResourceNotFoundException;
import com.misight.model.Pollutant;
import com.misight.model.MonitoringStation;
import com.misight.repository.PollutantRepo;
import com.misight.repository.MonitoringStationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PollutantService {

    private final PollutantRepo pollutantRepo;
    private final MonitoringStationRepo monitoringStationRepo;

    @Autowired
    public PollutantService(PollutantRepo pollutantRepo, MonitoringStationRepo monitoringStationRepo) {
        this.pollutantRepo = pollutantRepo;
        this.monitoringStationRepo = monitoringStationRepo;
    }

    public List<Pollutant> getAllPollutants() {
        return pollutantRepo.findAll();
    }

    public Pollutant getPollutantById(Long id) {
        return pollutantRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pollutant not found with id: " + id));
    }

    public Pollutant createPollutant(Pollutant pollutant, Long stationId) {
        if (pollutantRepo.existsByNameIgnoreCase(pollutant.getName())) {
            throw new IllegalArgumentException("Pollutant with this name already exists");
        }

        pollutant.setTimestamp(LocalDateTime.now());

        if (stationId != null) {
            MonitoringStation station = monitoringStationRepo.findById(stationId)
                    .orElseThrow(() -> new ResourceNotFoundException("Monitoring station not found"));
            pollutant.setMonitoringStation(station);
        }

        return pollutantRepo.save(pollutant);
    }

    public Pollutant updatePollutant(Long id, Pollutant pollutantDetails) {
        Pollutant pollutant = getPollutantById(id);
        pollutant.setName(pollutantDetails.getName());
        pollutant.setType(pollutantDetails.getType());
        pollutant.setMeasurement(pollutantDetails.getMeasurement());
        pollutant.setMeasuredValue(pollutantDetails.getMeasuredValue());
        pollutant.setTimestamp(LocalDateTime.now());

        return pollutantRepo.save(pollutant);
    }

    public void deletePollutant(Long id) {
        if (!pollutantRepo.existsById(id)) {
            throw new ResourceNotFoundException("Pollutant not found with id: " + id);
        }
        pollutantRepo.deleteById(id);
    }
}
