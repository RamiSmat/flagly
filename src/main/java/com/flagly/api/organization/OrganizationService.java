package com.flagly.api.organization;

import com.flagly.api.organization.dto.CreateOrganizationRequest;
import com.flagly.api.organization.dto.OrganizationResponse;
import com.flagly.api.organization.exceptions.OrganizationNotFoundException;
import com.flagly.api.organization.mapper.OrganizationMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class OrganizationService {

    private final OrganizationRepository organizationRepository;

    public OrganizationService(OrganizationRepository organizationRepository) {
        this.organizationRepository = organizationRepository;
    }

    public OrganizationResponse createOrganization(CreateOrganizationRequest request) {

        Organization organization =
                OrganizationMapper.toEntity(request);

        Organization savedOrganization =
                organizationRepository.save(organization);

        return OrganizationMapper.toResponse(savedOrganization);
    }

    public OrganizationResponse getOrganizationById(Long id) {

        Organization organization =
                organizationRepository.findById(id)
                        .orElseThrow(() ->
                                new OrganizationNotFoundException(id.toString()));

        return OrganizationMapper.toResponse(organization);
    }

    public Page<OrganizationResponse> getAllOrganizations(Pageable pageable) {

        return organizationRepository
                .findAll(pageable)
                .map(OrganizationMapper::toResponse);
    }

    public void deleteOrganizationById(Long id) {

        if (!organizationRepository.existsById(id)) {
            throw new OrganizationNotFoundException(id.toString());
        }

        organizationRepository.deleteById(id);
    }

}