package com.misight.controller;

import com.misight.model.Province;
import com.misight.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/provinces")
public class ProvinceController {

    private final ProvinceService provinceService;

    @Autowired
    public ProvinceController(ProvinceService provinceService) {
        this.provinceService = provinceService;
    }

    @PostMapping
    public ResponseEntity<Province> createProvince(@RequestBody Province province) {
        Province addedProvince = provinceService.addProvince(province);
        return new ResponseEntity<>(addedProvince, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Province> getProvinces() {
        return provinceService.getAllProvinces();
    }

    @GetMapping("/{province_id}")
    public Optional<Province> getProvinceById(@PathVariable("province_id") Integer province_id) {
        return provinceService.getProvinceById(province_id);
    }

    @DeleteMapping("/{province_id}")
    public boolean deleteProvince(@PathVariable("province_id") Integer province_id) {
        if (!provinceService.findById(province_id).equals(Optional.empty())) {
            provinceService.delProvince(province_id);
            return true;
        }
        return false;
    }

    @PutMapping("/{province_id}")
    public Province updateProvince(@PathVariable("province_id") Integer province_id,
                                   @RequestBody Map<String, String> body) {
        Province currentProvince = provinceService.getProvinceById(province_id).get();
        currentProvince.setProvince_name(body.get("province_name"));
        provinceService.addProvince(currentProvince);
        return currentProvince;
    }
}