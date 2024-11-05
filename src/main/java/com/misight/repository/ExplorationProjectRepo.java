package com.misight.repository;

import com.misight.model.ExplorationProject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExplorationProjectRepo extends JpaRepository<ExplorationProject, Long> {
    List<ExplorationProject> findByMineId(Long mineId);
}
