package com.misight.repository;

import com.misight.model.MineMineral;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MineMineralRepo extends JpaRepository<MineMineral, Long> {
}