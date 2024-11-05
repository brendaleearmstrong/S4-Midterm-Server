package com.misight.controller;

import com.misight.model.Province;
import com.misight.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/provinces")
@CrossOrigin(origins = "*")
public class ProvinceController {
    private final ProvinceService provinceService;

    @Autowired
    public ProvinceController(ProvinceService provinceService) {
        this.provinceService = provinceService;
    }

    @GetMapping
    public ResponseEntity<List<Province>> getAllProvinces() {
        return ResponseEntity.ok(provinceService.getAllProvinces());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Province> getProvinceById(@PathVariable Long id) {
        return ResponseEntity.ok(provinceService.getProvinceById(id));
    }

    @GetMapping("/{id}/mines")
    public ResponseEntity<Province> getProvinceWithMines(@PathVariable Long id) {
        return ResponseEntity.ok(provinceService.getProvinceWithMines(id));
    }

    @PostMapping
    public ResponseEntity<Province> createProvince(@RequestBody Province province) {
        return new ResponseEntity<>(provinceService.createProvince(province), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Province> updateProvince(@PathVariable Long id, @RequestBody Province province) {
        return ResponseEntity.ok(provinceService.updateProvince(id, province));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProvince(@PathVariable Long id) {
        provinceService.deleteProvince(id);
        return ResponseEntity.noContent().build();
    }
}