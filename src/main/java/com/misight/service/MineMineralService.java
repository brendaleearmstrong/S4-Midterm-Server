package com.misight.service;

import com.misight.exception.ResourceNotFoundException;
import com.misight.model.MineMineral;
import com.misight.repository.MineMineralRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MineMineralService {

    @Autowired
    private MineMineralRepo mineMineralRepo;

    public List<MineMineral> findAll() {
        return mineMineralRepo.findAll();
    }

    public MineMineral findById(Long id) {
        return mineMineralRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("MineMineral not found with id: " + id));
    }

    public MineMineral save(MineMineral mineMineral) {
        return mineMineralRepo.save(mineMineral);
    }

    public void deleteById(Long id) {
        if (!mineMineralRepo.existsById(id)) {
            throw new ResourceNotFoundException("MineMineral not found with id: " + id);
        }
        mineMineralRepo.deleteById(id);
    }
}