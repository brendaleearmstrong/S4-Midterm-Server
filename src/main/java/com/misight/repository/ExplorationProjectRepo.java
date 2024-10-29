package com.misight.repository;

import com.misight.model.ExplorationProject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExplorationProjectRepo extends JpaRepository<ExplorationProject, Integer> {
}
