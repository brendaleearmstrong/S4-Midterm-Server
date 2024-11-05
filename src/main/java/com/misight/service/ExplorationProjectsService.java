package com.misight.service;

import com.misight.model.ExplorationProjects;
import com.misight.repository.ExplorationProjectsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExplorationProjectsService {

    @Autowired
    private ExplorationProjectsRepo repo;

    public List<ExplorationProjects> getAllExplorationProjects() {
        return repo.findAll();
    }

    public ExplorationProjects getExplorationProjectById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public ExplorationProjects createExplorationProject(ExplorationProjects project) {
        return repo.save(project);
    }

    public ExplorationProjects updateExplorationProject(Long id, ExplorationProjects project) {
        Optional<ExplorationProjects> existingProject = repo.findById(id);
        if (existingProject.isPresent()) {
            project.setId(id);
            return repo.save(project);
        } else {
            return null;
        }
    }

    // Delete an exploration project by ID
    public void deleteExplorationProject(Long id) {
        repo.deleteById(id);
    }
}
