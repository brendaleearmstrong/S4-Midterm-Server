package com.misight.service;

import com.misight.exception.ResourceNotFoundException;
import com.misight.model.Mine;
import com.misight.model.Province;
import com.misight.repository.MineRepo;
import com.misight.repository.ProvinceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class MineService {
    private final MineRepo mineRepo;
    private final ProvinceRepo provinceRepo;

    @Autowired
    public MineService(MineRepo mineRepo, ProvinceRepo provinceRepo) {
        this.mineRepo = mineRepo;
        this.provinceRepo = provinceRepo;
    }

    public Mine createMine(Mine mine) {
        if (mine.getProvince() != null && mine.getProvince().getProvinceId() != null) {
            Province province = provinceRepo.findById(mine.getProvince().getProvinceId())
                    .orElseThrow(() -> new ResourceNotFoundException("Province not found"));
            mine.setProvince(province);
        }
        return mineRepo.save(mine);
    }

    public Mine getMineById(Long id) {
        return mineRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Mine not found with id: " + id));
    }

    public Mine getMineWithMinerals(Long id) {
        return mineRepo.findByIdWithMinerals(id)
                .orElseThrow(() -> new ResourceNotFoundException("Mine not found with id: " + id));
    }

    public List<Mine> getAllMines() {
        return mineRepo.findAll();
    }

    public List<Mine> getMinesByCompany(String company) {
        return mineRepo.findByCompany(company);
    }

    public List<Mine> getMinesByProvince(Long provinceId) {
        return mineRepo.findByProvinceProvinceId(provinceId);
    }

    public List<Mine> getMinesByMineral(Long mineralId) {
        return mineRepo.findByMineralsMineralId(mineralId);
    }

    public List<Mine> searchMinesByName(String name) {
        return mineRepo.findByMineNameContainingIgnoreCase(name);
    }

    public Mine updateMine(Long id, Mine mineDetails) {
        Mine mine = getMineById(id);

        mine.setMineName(mineDetails.getMineName());
        mine.setLocation(mineDetails.getLocation());
        mine.setCompany(mineDetails.getCompany());

        if (mineDetails.getProvince() != null && mineDetails.getProvince().getProvinceId() != null) {
            Province province = provinceRepo.findById(mineDetails.getProvince().getProvinceId())
                    .orElseThrow(() -> new ResourceNotFoundException("Province not found"));
            mine.setProvince(province);
        }

        return mineRepo.save(mine);
    }

    public void deleteMine(Long id) {
        if (!mineRepo.existsById(id)) {
            throw new ResourceNotFoundException("Mine not found with id: " + id);
        }
        mineRepo.deleteById(id);
    }
}