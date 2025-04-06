package com.restaurantManagement.service;

import com.restaurantManagement.dto.UnitsDto;
import com.restaurantManagement.models.Units;
import com.restaurantManagement.repository.UnitsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UnitServiceImpl implements UnitService {

    @Autowired
    private UnitsRepository unitsRepository;

    @Override
    public Units save(UnitsDto unitsDto) {

        Units unit = new Units();
        unit.setName(unitsDto.getName());
        unit.setAbbreviation(unitsDto.getAbbreviation());

        return unitsRepository.save(unit);
    }
}