package com.misight.service;

import com.misight.exception.ResourceNotFoundException;
import com.misight.model.Mineral;
import com.misight.repository.MineralRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class MineralService {
    private final MineralRepo mineralRepo;

    @Autowired
    public MineralService(MineralRepo mineralRepo) {
        this.mineralRepo = mineralRepo;
    }

    public Mineral createMineral(Mineral mineral) {
        if (mineralRepo.existsByNameIgnoreCase(mineral.getMineralName())) {
            throw new IllegalArgumentException("Mineral with this name already exists");
        }
        return mineralRepo.save(mineral);
    }

    public Mineral getMineralById(Long id) {
        return mineralRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Mineral not found with id: " + id));
    }

    public Mineral getMineralWithMines(Long id) {
        return mineralRepo.findByIdWithMines(id)
                .orElseThrow(() -> new ResourceNotFoundException("Mineral not found with id: " + id));
    }

    public List<Mineral> getAllMinerals() {
        return mineralRepo.findAll();
    }

    public Mineral updateMineral(Long id, Mineral mineralDetails) {
        Mineral mineral = getMineralById(id);

        if (!mineral.getMineralName().equalsIgnoreCase(mineralDetails.getMineralName()) &&
                mineralRepo.existsByNameIgnoreCase(mineralDetails.getMineralName())) {
            throw new IllegalArgumentException("Mineral with this name already exists");
        }

        mineral.setMineralName(mineralDetails.getMineralName());
        return mineralRepo.save(mineral);
    }

    public void deleteMineral(Long id) {
        if (!mineralRepo.existsById(id)) {
            throw new ResourceNotFoundException("Mineral not found with id: " + id);
        }
        mineralRepo.deleteById(id);
    }
}