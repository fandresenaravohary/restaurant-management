package com.restaurantManagement.service;

import com.restaurantManagement.dto.UnitsDto;
import com.restaurantManagement.dto.UnitsSummarized;

public interface UnitService {
    UnitsSummarized save(UnitsDto unitsDto);
}
