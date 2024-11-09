package com.misight.repository;

import com.misight.model.SafetyData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface SafetyDataRepo extends JpaRepository<SafetyData, Long> {
    List<SafetyData> findByMineId(Long mineId);
}
