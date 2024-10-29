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
public class ProvinceController {

    @Autowired
    private ProvinceService provinceService;

    @GetMapping
    public ResponseEntity<List<Province>> getAllProvinces() {
        List<Province> provinces = provinceService.getAllProvinces();
        return new ResponseEntity<>(provinces, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Province> getProvinceById(@PathVariable int id) {
        Province province = provinceService.getProvinceById(id);
        if (province != null) {
            return new ResponseEntity<>(province, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<Province> createProvince(@RequestBody Province province) {
        Province newProvince = provinceService.createProvince(province);
        return new ResponseEntity<>(newProvince, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Province> updateProvince(@PathVariable int id, @RequestBody Province provinceDetails) {
        Province updatedProvince = provinceService.updateProvince(id, provinceDetails);
        if (updatedProvince != null) {
            return new ResponseEntity<>(updatedProvince, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProvince(@PathVariable int id) {
        boolean isDeleted = provinceService.deleteProvince(id);
        if (isDeleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
