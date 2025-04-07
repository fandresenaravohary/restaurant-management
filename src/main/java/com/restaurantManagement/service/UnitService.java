package com.restaurantManagement.service;

import com.restaurantManagement.dto.UnitsDto;
import com.restaurantManagement.dto.UnitsSummarized;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UnitService {
    UnitsSummarized save(UnitsDto unitsDto);
    List<UnitsSummarized> findAll();
}
