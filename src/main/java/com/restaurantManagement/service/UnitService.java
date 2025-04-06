package com.restaurantManagement.service;

import com.restaurantManagement.dto.UnitsDto;
import com.restaurantManagement.models.Units;

public interface UnitService {
    Units save(UnitsDto unitsDto);
}
