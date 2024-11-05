package com.misight.repository;

import com.misight.model.Mineral;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface MineralRepo extends JpaRepository<Mineral, Long> {
    Optional<Mineral> findByNameIgnoreCase(String name);
    boolean existsByNameIgnoreCase(String name);

    @Query("SELECT m FROM Mineral m LEFT JOIN FETCH m.mineMinerals mm LEFT JOIN FETCH mm.mine WHERE m.id = :id")
    Optional<Mineral> findByIdWithMines(@Param("id") Long id);
}