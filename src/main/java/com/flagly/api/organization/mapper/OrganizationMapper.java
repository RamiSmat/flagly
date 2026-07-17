package com.flagly.api.organization.mapper;

import com.flagly.api.organization.Organization;
import com.flagly.api.organization.dto.CreateOrganizationRequest;
import com.flagly.api.organization.dto.OrganizationResponse;

public class OrganizationMapper {
    public static OrganizationResponse toResponse(Organization organization) {
        return new OrganizationResponse(
                organization.getId(),
                organization.getName(),
                organization.getCreatedAt(),
                organization.getUpdatedAt()
        );
    }
    public static Organization toEntity(CreateOrganizationRequest request) {
        Organization organization = new Organization();
        organization.setName(request.getName());
        return organization;
    }
}
