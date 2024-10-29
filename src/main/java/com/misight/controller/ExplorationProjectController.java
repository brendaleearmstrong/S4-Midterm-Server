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
@RequestMapping("/api/explorationProjects")
public class ExplorationProjectController {

    @Autowired
    private ExplorationProjectService explorationProjectService;

    @GetMapping
    public List<ExplorationProject> getAllExplorationProjects() {
        return explorationProjectService.getAllExplorationProjects();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExplorationProject> getExplorationProjectById(@PathVariable int id) {
        Optional<ExplorationProject> project = explorationProjectService.getExplorationProjectById(id);
        return project.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ExplorationProject> createExplorationProject(@RequestBody ExplorationProject explorationProject) {
        ExplorationProject createdProject = explorationProjectService.createExplorationProject(explorationProject);
        return new ResponseEntity<>(createdProject, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ExplorationProject> updateExplorationProject(@PathVariable int id, @RequestBody ExplorationProject updatedProject) {
        ExplorationProject updated = explorationProjectService.updateExplorationProject(id, updatedProject);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExplorationProject(@PathVariable int id) {
        if (explorationProjectService.deleteExplorationProject(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}