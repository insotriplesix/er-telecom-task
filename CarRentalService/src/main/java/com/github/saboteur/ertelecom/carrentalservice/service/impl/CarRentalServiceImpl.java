package com.github.saboteur.ertelecom.carrentalservice.service.impl;

import com.github.saboteur.ertelecom.carrentalservice.dto.OrganizationDto;
import com.github.saboteur.ertelecom.carrentalservice.mapper.OrganizationMapper;
import com.github.saboteur.ertelecom.carrentalservice.model.Organization;
import com.github.saboteur.ertelecom.carrentalservice.repository.OrganizationRepository;
import com.github.saboteur.ertelecom.carrentalservice.service.CarRentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CarRentalServiceImpl implements CarRentalService {

    @Autowired
    private OrganizationMapper organizationMapper;

    @Autowired
    private OrganizationRepository organizationRepository;

    @Override
    public Long createOrganization(OrganizationDto organizationDto) {
        return organizationRepository
            .save(organizationMapper.convertToEntity(organizationDto))
            .getId();
    }

    @Override
    public OrganizationDto getOrganization(Long organizationId) {
        return organizationRepository
            .findById(organizationId)
            .map(organizationMapper::convertToDto)
            .orElse(null);
    }

    @Override
    public Boolean updateOrganization(String organizationId, OrganizationDto organization) {
        return null;
    }

    @Override
    public Boolean deleteOrganization(String organizationId) {
        return null;
    }

}