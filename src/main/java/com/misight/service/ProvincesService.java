package com.misight.service;

import com.misight.model.Provinces;
import com.misight.repository.ProvincesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProvincesService {

    @Autowired
    private ProvincesRepo repo;

    // Method to retrieve all provinces
    public List<Provinces> getAllProvinces() {
        return repo.findAll();
    }

    // Method to get a province by ID
    public Provinces getProvinceById(Long id) {
        return repo.findById(id).orElse(null);
    }

    // Method to create a new province
    public Provinces createProvince(Provinces province) {
        return repo.save(province);
    }

    // Method to update an existing province
    public Provinces updateProvince(Long id, Provinces province) {
        Optional<Provinces> existingProvince = repo.findById(id);
        if (existingProvince.isPresent()) {
            province.setId(id);
            return repo.save(province);
        } else {
            return null;
        }
    }

    // Method to delete a province by ID
    public void deleteProvince(Long id) {
        repo.deleteById(id);
    }
}
