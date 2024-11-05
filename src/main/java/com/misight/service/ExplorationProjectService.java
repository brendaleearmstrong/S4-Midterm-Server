package com.misight.service;

import com.misight.model.ExplorationProject;
import com.misight.model.Mine;
import com.misight.repository.ExplorationProjectRepo;
import com.misight.repository.MineRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExplorationProjectService {

    private final ExplorationProjectRepo explorationProjectRepo;
    private final MineRepo mineRepo;

    @Autowired
    public ExplorationProjectService(ExplorationProjectRepo explorationProjectRepo, MineRepo mineRepo) {
        this.explorationProjectRepo = explorationProjectRepo;
        this.mineRepo = mineRepo;
    }

    public ExplorationProject addExplorationProject(ExplorationProject project, Long mineId) {
        if (mineId != null) {
            Optional<Mine> mineOptional = mineRepo.findById(mineId);
            mineOptional.ifPresent(project::setMine);
        }
        return explorationProjectRepo.save(project);
    }

    public List<ExplorationProject> getAllExplorationProjects() {
        return explorationProjectRepo.findAll();
    }

    public Optional<ExplorationProject> getExplorationProjectById(Long id) {
        return explorationProjectRepo.findById(id);
    }

    public ExplorationProject updateExplorationProject(Long id, ExplorationProject updatedProject, Long mineId) {
        Optional<ExplorationProject> existingProjectOpt = explorationProjectRepo.findById(id);
        if (existingProjectOpt.isPresent()) {
            ExplorationProject existingProject = existingProjectOpt.get();
            existingProject.setProjectName(updatedProject.getProjectName());
            if (mineId != null) {
                mineRepo.findById(mineId).ifPresent(existingProject::setMine);
            }
            return explorationProjectRepo.save(existingProject);
        }
        throw new RuntimeException("Exploration Project not found with id: " + id);
    }

    public void deleteExplorationProject(Long id) {
        explorationProjectRepo.deleteById(id);
    }
}
