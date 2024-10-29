package com.misight.controller;

import com.misight.model.ExplorationProject;
import com.misight.service.ExplorationProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/exploration-projects")
public class ExplorationProjectController {

    private final ExplorationProjectService projectService;

    @Autowired
    public ExplorationProjectController(ExplorationProjectService projectService) {
        this.projectService = projectService;
    }

    @PostMapping
    public ResponseEntity<ExplorationProject> createProject(@RequestBody ExplorationProject project) {
        ExplorationProject addedProject = projectService.addProject(project);
        return new ResponseEntity<>(addedProject, HttpStatus.CREATED);
    }

    @GetMapping
    public List<ExplorationProject> getAllProjects() {
        return projectService.getAllProjects();
    }

    @GetMapping("/{project_id}")
    public Optional<ExplorationProject> getProjectById(@PathVariable Integer project_id) {
        return projectService.getProjectById(project_id);
    }

    @DeleteMapping("/{project_id}")
    public ResponseEntity<Void> deleteProject(@PathVariable Integer project_id) {
        projectService.deleteProject(project_id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
