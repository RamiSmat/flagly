package com.flagly.api.project;

import com.flagly.api.organization.Organization;
import com.flagly.api.organization.OrganizationRepository;
import com.flagly.api.organization.exceptions.OrganizationNotFoundException;
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
    private final OrganizationRepository organizationRepository;
    public ProjectService(ProjectRepository projectRepository, OrganizationRepository organizationRepository) {
        this.projectRepository = projectRepository;
        this.organizationRepository = organizationRepository;
    }
    public ProjectResponse createProject(CreateProjectRequest request) {
        Organization organization = organizationRepository.findById(Long.valueOf(request.getOrganizationId()))
                .orElseThrow(() -> new OrganizationNotFoundException(request.getOrganizationId()));
        Project project = ProjectMapper.toEntity(request);
        project.setOrganization(organization);
        Project saved = projectRepository.save(project);
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
