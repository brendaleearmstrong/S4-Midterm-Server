package com.misight.service;

import com.misight.model.ExplorationProject;
import com.misight.repository.ExplorationProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ExplorationProjectService {

    private final ExplorationProjectRepo projectRepo;

    @Autowired
    public ExplorationProjectService(ExplorationProjectRepo projectRepo) {
        this.projectRepo = projectRepo;
    }

    public ExplorationProject addProject(ExplorationProject project) {
        return projectRepo.save(project);
    }

    public List<ExplorationProject> getAllProjects() {
        return projectRepo.findAll();
    }

    public Optional<ExplorationProject> getProjectById(Integer project_id) {
        return projectRepo.findById(project_id);
    }

    public void deleteProject(Integer project_id) {
        projectRepo.deleteById(project_id);
    }
}