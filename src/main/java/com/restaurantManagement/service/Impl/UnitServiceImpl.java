package com.restaurantManagement.service.Impl;

import com.restaurantManagement.dto.UnitsDto;
import com.restaurantManagement.service.UnitService;
import com.restaurantManagement.summarized.UnitsSummarized;
import com.restaurantManagement.mapper.UnitsMapper;
import com.restaurantManagement.models.Units;
import com.restaurantManagement.repository.UnitsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UnitServiceImpl implements UnitService {

    private final UnitsRepository unitsRepository;
    private final UnitsMapper unitsMapper;

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

    @Override
    public void delete(Long id) {
        if (unitsRepository.existsById(id)) {
            unitsRepository.deleteById(id);
        } else {
            throw new RuntimeException("Unit not found with ID: " + id);
        }
    }
}
