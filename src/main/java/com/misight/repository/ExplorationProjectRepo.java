package com.misight.repository;

import com.misight.model.ExplorationProject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface ExplorationProjectRepo extends JpaRepository<ExplorationProject, Long> {
    List<ExplorationProject> findByMine_MineId(Long mineId);

    // Add these methods as needed:
    @Query("SELECT ep FROM ExplorationProject ep JOIN FETCH ep.mine WHERE ep.id = :id")
    Optional<ExplorationProject> findByIdWithMine(@Param("id") Long id);

    List<ExplorationProject> findByStartDateBetween(LocalDate startDate, LocalDate endDate);

    List<ExplorationProject> findByEndDateAfter(LocalDate date);
}
