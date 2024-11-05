package com.misight.controller;

import com.misight.model.ExplorationProject;
import com.misight.service.ExplorationProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/exploration-projects")
@CrossOrigin(origins = "*")
public class ExplorationProjectController {
    private final ExplorationProjectService explorationProjectService;

    @Autowired
    public ExplorationProjectController(ExplorationProjectService explorationProjectService) {
        this.explorationProjectService = explorationProjectService;
    }

    @PostMapping("/mine/{mineId}")
    public ResponseEntity<ExplorationProject> createProject(
            @PathVariable Long mineId,
            @RequestBody ExplorationProject project) {
        return new ResponseEntity<>(
                explorationProjectService.createProject(mineId, project),
                HttpStatus.CREATED
        );
    }

    @GetMapping
    public ResponseEntity<List<ExplorationProject>> getAllProjects() {
        return ResponseEntity.ok(explorationProjectService.getAllProjects());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExplorationProject> getProjectById(@PathVariable Long id) {
        return ResponseEntity.ok(explorationProjectService.getProjectById(id));
    }

    @GetMapping("/mine/{mineId}")
    public ResponseEntity<List<ExplorationProject>> getProjectsByMine(@PathVariable Long mineId) {
        return ResponseEntity.ok(explorationProjectService.getProjectsByMine(mineId));
    }

    @GetMapping("/range")
    public ResponseEntity<List<ExplorationProject>> getProjectsByDateRange(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        return ResponseEntity.ok(explorationProjectService.getProjectsByDateRange(startDate, endDate));
    }

    @GetMapping("/active")
    public ResponseEntity<List<ExplorationProject>> getActiveProjects(
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        date = date != null ? date : LocalDate.now();
        return ResponseEntity.ok(explorationProjectService.getActiveProjects(date));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ExplorationProject> updateProject(
            @PathVariable Long id,
            @RequestBody ExplorationProject project) {
        return ResponseEntity.ok(explorationProjectService.updateProject(id, project));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProject(@PathVariable Long id) {
        explorationProjectService.deleteProject(id);
        return ResponseEntity.noContent().build();
    }
}