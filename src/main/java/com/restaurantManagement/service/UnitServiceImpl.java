package com.restaurantManagement.service;

import com.restaurantManagement.dto.UnitsDto;
import com.restaurantManagement.dto.UnitsSummarized;
import com.restaurantManagement.models.Units;
import com.restaurantManagement.repository.UnitsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UnitServiceImpl implements UnitService {

    private UnitsRepository unitsRepository;

    @Override
    public UnitsSummarized save(UnitsDto unitsDto) {
        Units unit;

        if (unitsDto.getId() != null) {
            unit = unitsRepository.findById(unitsDto.getId())
                    .orElseThrow(() -> new IllegalArgumentException("Unit not found with ID: " + unitsDto.getId()));
        } else {
            unit = new Units();
        }

        unit.setName(unitsDto.getName());
        unit.setAbbreviation(unitsDto.getAbbreviation());

        Units savedUnit = unitsRepository.save(unit);

        return new UnitsSummarized(
                savedUnit.getId(),
                savedUnit.getName(),
                savedUnit.getAbbreviation(),
                savedUnit.getCreatedAt(),
                savedUnit.getUpdatedAt()
        );
    }
}
