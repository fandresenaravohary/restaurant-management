package com.restaurantManagement.service;

import com.restaurantManagement.dto.UnitsDto;
import com.restaurantManagement.models.Units;
import com.restaurantManagement.repository.UnitsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UnitServiceImpl implements UnitService {

    private UnitsRepository unitsRepository;

    @Override
    public Units save(UnitsDto unitsDto) {
        Units unit;

        if (unitsDto.getId() != null) {
            unit = unitsRepository.findById(unitsDto.getId())
                    .orElseThrow(() -> new IllegalArgumentException("Unit not found with ID: " + unitsDto.getId()));

        } else {
            unit = new Units();
        }
        unit.setName(unitsDto.getName());
        unit.setAbbreviation(unitsDto.getAbbreviation());

        return unitsRepository.save(unit);
    }
}