package com.misight.controller;

import com.misight.model.ExplorationProjects;
import com.misight.service.ExplorationProjectsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/explorationProjects")
public class ExplorationProjectsController {

    @Autowired
    private ExplorationProjectsService service;

    @GetMapping
    public List<ExplorationProjects> getAllExplorationProjects() {
        return service.getAllExplorationProjects();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExplorationProjects> getExplorationProjectById(@PathVariable Long id) {
        ExplorationProjects project = service.getExplorationProjectById(id);
        return project != null ? ResponseEntity.ok(project) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ExplorationProjects createExplorationProject(@RequestBody ExplorationProjects project) {
        return service.createExplorationProject(project);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ExplorationProjects> updateExplorationProject(@PathVariable Long id, @RequestBody ExplorationProjects project) {
        ExplorationProjects updatedProject = service.updateExplorationProject(id, project);
        return updatedProject != null ? ResponseEntity.ok(updatedProject) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExplorationProject(@PathVariable Long id) {
        service.deleteExplorationProject(id);
        return ResponseEntity.noContent().build();
    }
}
