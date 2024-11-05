package com.misight.service;

import com.misight.model.Mines;
import com.misight.model.Minerals;
import com.misight.model.Provinces;
import com.misight.repository.MinesRepo;
import com.misight.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
@Transactional
public class MinesService {

    @Autowired
    private MinesRepo repo;

    @Autowired
    private ProvincesService provincesService;

    public List<Mines> getAllMines() {
        return repo.findAll();
    }

    public Mines getMineById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Mine not found with id: " + id));
    }

    public Mines createMine(Mines mine) {
        if (mine.getProvince() != null && mine.getProvince().getId() != null) {
            Provinces province = provincesService.getProvinceById(mine.getProvince().getId());
            mine.setProvince(province);
        }
        return repo.save(mine);
    }

    // Update an existing mine's basic details and province
    public Mines updateMine(Long id, Mines mineDetails) {
        Mines mine = getMineById(id);

        mine.setName(mineDetails.getName());
        mine.setLocation(mineDetails.getLocation());
        mine.setCompany(mineDetails.getCompany());

        if (mineDetails.getProvince() != null && mineDetails.getProvince().getId() != null) {
            Provinces province = provincesService.getProvinceById(mineDetails.getProvince().getId());
            mine.setProvince(province);
        }

        if (mineDetails.getMinerals() != null) {
            mine.setMinerals(mineDetails.getMinerals());
        }

        return repo.save(mine);
    }

    public Mines updateMineProvince(Long mineId, Long provinceId) {
        Mines mine = getMineById(mineId);
        Provinces province = provincesService.getProvinceById(provinceId);
        mine.setProvince(province);
        return repo.save(mine);
    }

    public Set<Minerals> getMineMinerals(Long mineId) {
        Mines mine = getMineById(mineId);
        return mine.getMinerals();
    }


    public void deleteMine(Long id) {
        if (!repo.existsById(id)) {
            throw new ResourceNotFoundException("Mine not found with id: " + id);
        }
        repo.deleteById(id);
    }
}

