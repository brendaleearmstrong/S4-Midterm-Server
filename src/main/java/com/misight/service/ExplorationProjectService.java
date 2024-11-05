package com.misight.service;

import com.misight.model.ExplorationProject;
import com.misight.model.Mine;
import com.misight.repository.ExplorationProjectRepo;
import com.misight.repository.MineRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDate;
import java.util.List;
import com.misight.exception.ResourceNotFoundException;

@Service
@Transactional
public class ExplorationProjectService {
    private final ExplorationProjectRepo explorationProjectRepo;
    private final MineRepo mineRepo;

    @Autowired
    public ExplorationProjectService(ExplorationProjectRepo explorationProjectRepo, MineRepo mineRepo) {
        this.explorationProjectRepo = explorationProjectRepo;
        this.mineRepo = mineRepo;
    }

    public ExplorationProject createProject(Long mineId, ExplorationProject project) {
        Mine mine = mineRepo.findById(mineId)
                .orElseThrow(() -> new ResourceNotFoundException("Mine not found with id: " + mineId));

        project.setMine(mine);

        if (project.getEndDate().isBefore(project.getStartDate())) {
            throw new IllegalArgumentException("End date cannot be before start date");
        }

        return explorationProjectRepo.save(project);
    }

    public ExplorationProject getProjectById(Long id) {
        return explorationProjectRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Exploration project not found with id: " + id));
    }

    public List<ExplorationProject> getAllProjects() {
        return explorationProjectRepo.findAll();
    }

    public List<ExplorationProject> getProjectsByMine(Long mineId) {
        if (!mineRepo.existsById(mineId)) {
            throw new ResourceNotFoundException("Mine not found with id: " + mineId);
        }
        return explorationProjectRepo.findByMine_MineId(mineId);
    }

    public List<ExplorationProject> getProjectsByDateRange(LocalDate startDate, LocalDate endDate) {
        return explorationProjectRepo.findByStartDateBetween(startDate, endDate);
    }

    public List<ExplorationProject> getActiveProjects(LocalDate date) {
        return explorationProjectRepo.findByEndDateAfter(date);
    }

    public ExplorationProject updateProject(Long id, ExplorationProject projectDetails) {
        ExplorationProject project = getProjectById(id);

        if (projectDetails.getEndDate().isBefore(projectDetails.getStartDate())) {
            throw new IllegalArgumentException("End date cannot be before start date");
        }

        project.setName(projectDetails.getName());
        project.setStartDate(projectDetails.getStartDate());
        project.setEndDate(projectDetails.getEndDate());
        project.setBudget(projectDetails.getBudget());

        return explorationProjectRepo.save(project);
    }

    public void deleteProject(Long id) {
        if (!explorationProjectRepo.existsById(id)) {
            throw new ResourceNotFoundException("Exploration project not found with id: " + id);
        }
        explorationProjectRepo.deleteById(id);
    }
}
