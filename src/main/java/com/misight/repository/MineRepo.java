package com.misight.repository;

import com.misight.model.Mine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MineRepo extends JpaRepository<Mine, Integer> {
}