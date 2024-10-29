package com.misight.service;

import com.misight.model.Province;
import com.misight.repository.ProvinceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProvinceService {

    @Autowired
    private ProvinceRepo provinceRepo;

    public List<Province> getAllProvinces() {
        return provinceRepo.findAll();
    }

    public Province getProvinceById(int id) {
        Optional<Province> province = provinceRepo.findById(id);
        return province.orElse(null);
    }

    public Province createProvince(Province province) {
        return provinceRepo.save(province);
    }

    public Province updateProvince(int id, Province provinceDetails) {
        Optional<Province> optionalProvince = provinceRepo.findById(id);
        if (optionalProvince.isPresent()) {
            Province existingProvince = optionalProvince.get();
            existingProvince.setProvinceName(provinceDetails.getProvinceName());
            return provinceRepo.save(existingProvince);
        }
        return null;
    }

    public boolean deleteProvince(int id) {
        if (provinceRepo.existsById(id)) {
            provinceRepo.deleteById(id);
            return true;
        }
        return false;
    }
}
