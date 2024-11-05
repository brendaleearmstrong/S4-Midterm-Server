package com.misight.controller;

import com.misight.model.Provinces;
import com.misight.service.ProvincesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/provinces")
public class ProvincesController {  // Class name matches file name

    @Autowired
    private ProvincesService service;

    // Get all provinces
    @GetMapping
    public List<Provinces> getAllProvinces() {
        return service.getAllProvinces();
    }

    // Get province by ID
    @GetMapping("/{id}")
    public ResponseEntity<Provinces> getProvinceById(@PathVariable Long id) {
        Provinces province = service.getProvinceById(id);
        return province != null ? ResponseEntity.ok(province) : ResponseEntity.notFound().build();
    }

    // Create a new province
    @PostMapping
    public Provinces createProvince(@RequestBody Provinces province) {
        return service.createProvince(province);
    }

    // Update an existing province by ID
    @PutMapping("/{id}")
    public ResponseEntity<Provinces> updateProvince(@PathVariable Long id, @RequestBody Provinces province) {
        Provinces updatedProvince = service.updateProvince(id, province);
        return updatedProvince != null ? ResponseEntity.ok(updatedProvince) : ResponseEntity.notFound().build();
    }

    // Delete a province by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProvince(@PathVariable Long id) {
        service.deleteProvince(id);
        return ResponseEntity.noContent().build();
    }
}
