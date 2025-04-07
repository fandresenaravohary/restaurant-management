package com.restaurantManagement.mapper;

import com.restaurantManagement.dto.UnitsDto;
import com.restaurantManagement.dto.UnitsSummarized;
import com.restaurantManagement.models.Units;
import org.springframework.stereotype.Component;

@Component
public class UnitsMapper {

    private Units createUnitFromProperties(Long id, String name, String abbreviation) {
        Units unit = new Units();
        unit.setId(id);
        unit.setName(name);
        unit.setAbbreviation(abbreviation);
        return unit;
    }

    public UnitsSummarized toUnitsSummarized(Units unit) {
        if (unit == null) {
            return null;
        }
        return new UnitsSummarized(
                unit.getId(),
                unit.getName(),
                unit.getAbbreviation(),
                unit.getCreatedAt(),
                unit.getUpdatedAt()
        );
    }

    public Units toUnit(UnitsDto unitsDto) {
        if (unitsDto == null) {
            return null;
        }
        return createUnitFromProperties(unitsDto.getId(), unitsDto.getName(), unitsDto.getAbbreviation());
    }

    public Units toUnitFromSummarized(UnitsSummarized unitsSummarized) {
        if (unitsSummarized == null) {
            return null;
        }
        return createUnitFromProperties(unitsSummarized.getId(), unitsSummarized.getName(), unitsSummarized.getAbbreviation());
    }
}
