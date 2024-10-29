package com.misight.service;

import com.misight.model.ExplorationProject;
import com.misight.repository.ExplorationProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExplorationProjectService {

    @Autowired
    private ExplorationProjectRepo explorationProjectRepo;

    public List<ExplorationProject> getAllExplorationProjects() {
        return explorationProjectRepo.findAll();
    }

    public Optional<ExplorationProject> getExplorationProjectById(int id) {
        return explorationProjectRepo.findById(id);
    }

    public ExplorationProject createExplorationProject(ExplorationProject explorationProject) {
        return explorationProjectRepo.save(explorationProject);
    }

    public ExplorationProject updateExplorationProject(int id, ExplorationProject updatedProject) {
        return explorationProjectRepo.findById(id)
                .map(existingProject -> {
                    existingProject.setProjectName(updatedProject.getProjectName());
                    existingProject.setMine(updatedProject.getMine());
                    existingProject.setStartDate(updatedProject.getStartDate());
                    existingProject.setEndDate(updatedProject.getEndDate());
                    existingProject.setBudget(updatedProject.getBudget());
                    return explorationProjectRepo.save(existingProject);
                })
                .orElse(null);
    }

    public boolean deleteExplorationProject(int id) {
        if (explorationProjectRepo.existsById(id)) {
            explorationProjectRepo.deleteById(id);
            return true;
        }
        return false;
    }
}