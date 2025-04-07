package com.restaurantManagement.service;

import com.restaurantManagement.dto.UnitsDto;
import com.restaurantManagement.dto.UnitsSummarized;
import com.restaurantManagement.mapper.UnitsMapper;
import com.restaurantManagement.models.Units;
import com.restaurantManagement.repository.UnitsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UnitServiceImpl implements UnitService {

    private UnitsRepository unitsRepository;
    private UnitsMapper unitsMapper;

    @Override
    public UnitsSummarized save(UnitsDto unitsDto) {
        Units unit = unitsMapper.convertToUnit(unitsDto);
        Units savedUnit = unitsRepository.save(unit);
        return unitsMapper.convertToUnitsSummarized(savedUnit);
    }

    @Override
    public List<UnitsSummarized> findAll() {
        return unitsRepository.findAll()
                .stream()
                .map(unitsMapper::convertToUnitsSummarized)
                .collect(Collectors.toList());
    }
}
