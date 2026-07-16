package com.flagly.api.project;

import com.flagly.api.project.dto.ProjectResponse;
import com.flagly.api.project.exceptions.ProjectNotFoundException;
import com.flagly.api.project.dto.CreateProjectRequest;
import com.flagly.api.project.mapper.ProjectMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {
    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }
    public ProjectResponse createProject(CreateProjectRequest project) {
        Project saved = projectRepository.save(ProjectMapper.toEntity(project));
        return ProjectMapper.toResponse(saved);


    }

    public ProjectResponse getProjectById(Long id) {
        Project project = projectRepository.findById(id)
                .orElseThrow(()-> new ProjectNotFoundException(id));
        return ProjectMapper.toResponse(project);
    }

    public Page<ProjectResponse> getAllProjects(Pageable pageable) {
        return projectRepository.findAll(pageable)
                .map(ProjectMapper::toResponse);
    }

    public void deleteProjectById(Long id) {
        projectRepository.deleteById(id);
    }

    public void deleteAllProjects() {
        projectRepository.deleteAll();
    }
}
