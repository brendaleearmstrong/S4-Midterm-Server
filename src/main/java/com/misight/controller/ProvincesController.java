package com.misight.controller;

import com.misight.model.Provinces;
import com.misight.service.ProvincesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/provinces")
public class ProvincesController {

    @Autowired
    private ProvincesService provincesService;

    @GetMapping
    public List<Provinces> getAllProvinces() {
        return provincesService.getAllProvinces();
    }

    @GetMapping("/{id}")
    public Provinces getProvinceById(@PathVariable Long id) {
        return provincesService.getProvinceById(id);
    }

    @PostMapping
    public Provinces createProvince(@RequestBody Provinces province) {
        return provincesService.createProvince(province);
    }

    @PutMapping("/{id}")
    public Provinces updateProvince(@PathVariable Long id, @RequestBody Provinces province) {
        return provincesService.updateProvince(id, province);
    }

    @DeleteMapping("/{id}")
    public void deleteProvince(@PathVariable Long id) {
        provincesService.deleteProvince(id);
    }
}
