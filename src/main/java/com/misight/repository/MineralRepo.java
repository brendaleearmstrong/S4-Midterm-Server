package com.misight.repository;

import com.misight.model.Mineral;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface MineralRepo extends JpaRepository<Mineral, Long> {

    @Query("SELECT m FROM Mineral m JOIN m.mines mine WHERE mine.name = :mineName")
    List<Mineral> findMineralsByMineName(@Param("mineName") String mineName);

    Optional<Mineral> findByName(String name);
}
