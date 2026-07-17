package com.flagly.api.organization.exceptions;

import jakarta.validation.constraints.NotBlank;

public class OrganizationNotFoundException extends RuntimeException {
    public OrganizationNotFoundException(@NotBlank String id) {
        super("Organization with id " + id + " was not found");
    }
}