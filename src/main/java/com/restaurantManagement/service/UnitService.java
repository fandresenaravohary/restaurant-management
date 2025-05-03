package com.restaurantManagement.service;

import com.restaurantManagement.dto.UnitsDto;
import com.restaurantManagement.summarized.UnitsSummarized;

import java.util.List;

public interface UnitService {
    UnitsSummarized save(UnitsDto unitsDto);
    List<UnitsSummarized> findAll();
    void delete(Long id);
}
