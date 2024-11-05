package com.misight.controller;

import com.misight.model.Province;
import com.misight.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/provinces")
public class ProvinceController {

    @Autowired
    private ProvinceService provinceService;

    @GetMapping
    public List<Province> getAllProvinces() {
        return provinceService.getAllProvinces();
    }

    @GetMapping("/{id}")
    public Province getProvinceById(@PathVariable Long id) {
        return provinceService.getProvinceById(id);
    }

    @PostMapping
    public Province createProvince(@RequestBody Province province) {
        return provinceService.createProvince(province);
    }

    @PutMapping("/{id}")
    public Province updateProvince(@PathVariable Long id, @RequestBody Province province) {
        return provinceService.updateProvince(id, province);
    }

    @DeleteMapping("/{id}")
    public void deleteProvince(@PathVariable Long id) {
        provinceService.deleteProvince(id);
    }
}
