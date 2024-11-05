package com.misight.service;

import com.misight.model.Mines;
import com.misight.repository.MinesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MinesService {

    @Autowired
    private MinesRepo repo;

    // Retrieve all mines
    public List<Mines> getAllMines() {
        return repo.findAll();
    }

    // Retrieve a specific mine by ID
    public Mines getMineById(Long id) {
        return repo.findById(id).orElse(null);
    }

    // Create a new mine
    public Mines createMine(Mines mine) {
        return repo.save(mine);
    }

    // Update an existing mine by ID
    public Mines updateMine(Long id, Mines mine) {
        Optional<Mines> existingMine = repo.findById(id);
        if (existingMine.isPresent()) {
            mine.setId(id);
            return repo.save(mine);
        } else {
            return null;
        }
    }

    // Delete a mine by ID
    public void deleteMine(Long id) {
        repo.deleteById(id);
    }
}
