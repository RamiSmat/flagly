package com.flagly.api.project.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class CreateProjectRequest {
    @NotBlank(message = "Project name is required")
    private String name;
}
