package com.misight.repository;

import com.misight.model.Mine;
import com.misight.model.Mineral;
import com.misight.model.MineMineral;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface MineMineralRepo extends JpaRepository<MineMineral, Integer> {
    Optional<MineMineral> findByMineAndMineral(Mine mine, Mineral mineral);

    // This method checks if a MineMineral association already exists
    boolean existsByMineAndMineral(Mine mine, Mineral mineral);
}
