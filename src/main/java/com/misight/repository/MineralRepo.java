package com.misight.repository;

import com.misight.model.Mineral;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MineralRepo extends JpaRepository<Mineral, Integer> {

}
