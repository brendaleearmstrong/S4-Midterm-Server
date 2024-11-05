package com.misight.repository;

import com.misight.model.Mine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface MineRepo extends JpaRepository<Mine, Long> {
    List<Mine> findByMineralsMineralId(Long mineralId);
    List<Mine> findByProvinceProvinceId(Long provinceId);
    List<Mine> findByCompany(String company);
    Optional<Mine> findByIdWithMinerals(Long id);
    List<Mine> findByMineNameContainingIgnoreCase(String name);
}