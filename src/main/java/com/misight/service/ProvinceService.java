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

    public Province getProvinceById(Long id) {
        return provinceRepo.findById(id).orElse(null);
    }

    public Province createProvince(Province province) {
        return provinceRepo.save(province);
    }

    public Province updateProvince(Long id, Province provinceDetails) {
        Optional<Province> optionalProvince = provinceRepo.findById(id);
        if (optionalProvince.isPresent()) {
            Province province = optionalProvince.get();
            province.setName(provinceDetails.getName());
            return provinceRepo.save(province);
        }
        return null;
    }

    public void deleteProvince(Long id) {
        provinceRepo.deleteById(id);
    }
}
