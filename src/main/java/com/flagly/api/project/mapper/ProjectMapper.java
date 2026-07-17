package com.flagly.api.project.mapper;

import com.flagly.api.project.Project;
import com.flagly.api.project.dto.CreateProjectRequest;
import com.flagly.api.project.dto.ProjectResponse;

public class ProjectMapper {
    private ProjectMapper() {
    }
    public static Project toEntity(CreateProjectRequest request) {
        Project project = new Project();
        project.setName(request.getName());
        return project;
    }

    public static ProjectResponse toResponse(Project project) {
        return new ProjectResponse(
                project.getId(),
                project.getName(),
                project.getCreatedAt(),
                project.getUpdatedAt()
        );
    }
}