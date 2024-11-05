package com.misight.controller;

import com.misight.model.ExplorationProject;
import com.misight.service.ExplorationProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/exploration-projects")
public class ExplorationProjectController {

    private final ExplorationProjectService explorationProjectService;

    @Autowired
    public ExplorationProjectController(ExplorationProjectService explorationProjectService) {
        this.explorationProjectService = explorationProjectService;
    }

    @PostMapping("/add")
    public ResponseEntity<ExplorationProject> addExplorationProject(
            @RequestBody ExplorationProject project,
            @RequestParam(value = "mineId", required = false) Long mineId) {
        ExplorationProject createdProject = explorationProjectService.addExplorationProject(project, mineId);
        return ResponseEntity.ok(createdProject);
    }

    @GetMapping("/all")
    public ResponseEntity<List<ExplorationProject>> getAllExplorationProjects() {
        List<ExplorationProject> projects = explorationProjectService.getAllExplorationProjects();
        return ResponseEntity.ok(projects);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExplorationProject> getExplorationProjectById(@PathVariable Long id) {
        Optional<ExplorationProject> project = explorationProjectService.getExplorationProjectById(id);
        return project.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ExplorationProject> updateExplorationProject(
            @PathVariable Long id,
            @RequestBody ExplorationProject updatedProject,
            @RequestParam(value = "mineId", required = false) Long mineId) {
        ExplorationProject project = explorationProjectService.updateExplorationProject(id, updatedProject, mineId);
        return ResponseEntity.ok(project);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteExplorationProject(@PathVariable Long id) {
        explorationProjectService.deleteExplorationProject(id);
        return ResponseEntity.noContent().build();
    }
}
