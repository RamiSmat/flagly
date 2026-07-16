package com.flagly.api.project.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter
@AllArgsConstructor
public class ProjectResponse {
    private Long id;
    private String name;
}
