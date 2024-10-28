// File: src/main/java/com/misight/service/ProvinceService.java
package com.misight.service;

import com.misight.model.Province;
import com.misight.repository.ProvinceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProvinceService {

    private final ProvinceRepo provinceRepo;

    @Autowired
    public ProvinceService(ProvinceRepo provinceRepo) {
        this.provinceRepo = provinceRepo;
    }

    public Province addProvince(Province province) {
        return provinceRepo.save(province);
    }

    public List<Province> getAllProvinces() {
        return provinceRepo.findAll();
    }

    public Optional<Province> getProvinceById(Integer province_id) {
        return provinceRepo.findById(province_id);
    }

    public Optional<Province> findById(Integer province_id) {
        return provinceRepo.findById(province_id);
    }

    public void delProvince(Integer province_id) {
        provinceRepo.deleteById(province_id);
    }
}