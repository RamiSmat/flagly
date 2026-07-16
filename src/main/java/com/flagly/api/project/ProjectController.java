package com.flagly.api.project;

import com.flagly.api.project.dto.ProjectResponse;
import com.flagly.api.project.dto.CreateProjectRequest;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectController {
    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }
    @PostMapping("/create")
    public ProjectResponse createProject(@RequestBody @Valid CreateProjectRequest project) {
        return projectService.createProject(project);
    }

    @GetMapping("/{id}")
    public ProjectResponse getProjectById(@PathVariable Long id) {
        return projectService.getProjectById(id);
    }
    @GetMapping
    public List<ProjectResponse> getAllProjects() {
        return projectService.getAllProjects();
    }
    @DeleteMapping("/{id}")
    public void deleteProject(@PathVariable Long id){
        projectService.deleteProjectById(id);
    }
    @DeleteMapping
    public void deleteAllProjects(){
        projectService.deleteAllProjects();
    }
}
