package com.flagly.api.organization.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class CreateOrganizationRequest {

    @NotBlank
    private String name;
}