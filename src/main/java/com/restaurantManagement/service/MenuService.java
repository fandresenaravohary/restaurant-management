package com.restaurantManagement.service;

import com.restaurantManagement.dto.MenuDto;
import com.restaurantManagement.summarized.MenuSummarized;

import java.util.List;

public interface MenuService {
    MenuSummarized save(MenuDto menuDto);
    List<MenuSummarized> findAll();
    void delete(Long id);
}
