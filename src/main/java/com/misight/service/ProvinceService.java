package com.misight.service;

import com.misight.exception.ResourceNotFoundException;
import com.misight.model.Province;
import com.misight.repository.ProvinceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class ProvinceService {
    private final ProvinceRepo provinceRepo;

    @Autowired
    public ProvinceService(ProvinceRepo provinceRepo) {
        this.provinceRepo = provinceRepo;
    }

    public Province createProvince(Province province) {
        if (provinceRepo.existsByProvinceNameIgnoreCase(province.getProvinceName())) {
            throw new IllegalArgumentException("Province with this name already exists");
        }
        return provinceRepo.save(province);
    }

    public Province getProvinceById(Long id) {
        return provinceRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Province not found with id: " + id));
    }

    public Province getProvinceWithMines(Long id) {
        return provinceRepo.findByIdWithMines(id)
                .orElseThrow(() -> new ResourceNotFoundException("Province not found with id: " + id));
    }

    public List<Province> getAllProvinces() {
        return provinceRepo.findAll();
    }

    public Province updateProvince(Long id, Province provinceDetails) {
        Province province = getProvinceById(id);

        if (!province.getProvinceName().equalsIgnoreCase(provinceDetails.getProvinceName()) &&
                provinceRepo.existsByProvinceNameIgnoreCase(provinceDetails.getProvinceName())) {
            throw new IllegalArgumentException("Province with this name already exists");
        }

        province.setProvinceName(provinceDetails.getProvinceName());
        return provinceRepo.save(province);
    }

    public void deleteProvince(Long id) {
        if (!provinceRepo.existsById(id)) {
            throw new ResourceNotFoundException("Province not found with id: " + id);
        }
        provinceRepo.deleteById(id);
    }
}