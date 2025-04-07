package com.restaurantManagement.mapper;

import com.restaurantManagement.dto.UnitsDto;
import com.restaurantManagement.dto.UnitsSummarized;
import com.restaurantManagement.models.Units;
import org.springframework.stereotype.Component;

@Component
public class UnitsMapper {

    public UnitsSummarized convertToUnitsSummarized(Units unit) {
        if (unit == null) {
            return null;
        }

        return UnitsSummarized.builder()
                .id(unit.getId())
                .name(unit.getName())
                .abbreviation(unit.getAbbreviation())
                .createdAt(unit.getCreatedAt())
                .updatedAt(unit.getUpdatedAt())
                .build();
    }

    public Units convertToUnit(UnitsDto unitsDto) {
        if (unitsDto == null) {
            return null;
        }

        return Units.builder()
                .id(unitsDto.getId())
                .name(unitsDto.getName())
                .abbreviation(unitsDto.getAbbreviation())
                .build();
    }
}
