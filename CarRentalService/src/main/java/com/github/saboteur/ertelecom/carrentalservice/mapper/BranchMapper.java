package com.github.saboteur.ertelecom.carrentalservice.mapper;

import com.github.saboteur.ertelecom.carrentalservice.dto.BranchDto;
import com.github.saboteur.ertelecom.carrentalservice.model.Branch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BranchMapper implements Mapper<Branch, BranchDto> {

    @Autowired
    private LocationMapper locationMapper;

    @Override
    public BranchDto convertToDto(Branch entity) {
        return new BranchDto(
            entity.getCode(),
            entity.getPhone(),
            entity.getLocation() == null
                ? null
                : locationMapper.convertToDto(entity.getLocation())
        );
    }

    @Override
    public Branch convertToEntity(BranchDto dto) {
        if (dto == null || dto.getCode() == null)
            throw new IllegalArgumentException("A branch requires 'code' information");

        return new Branch(
            dto.getCode(),
            dto.getPhone(),
            dto.getLocation() == null
                ? null
                : locationMapper.convertToEntity(dto.getLocation())
        );
    }

}
