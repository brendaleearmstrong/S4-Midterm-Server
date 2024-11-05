package com.misight.repository;

import com.misight.model.ExplorationProjects;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExplorationProjectsRepo extends JpaRepository<ExplorationProjects, Long> {

}
