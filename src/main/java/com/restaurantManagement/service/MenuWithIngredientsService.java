package com.restaurantManagement.service;

import com.restaurantManagement.dto.MenuWithIngredientsDto;
import com.restaurantManagement.summarized.MenuWithIngredientsSummarized;

import java.util.List;

public interface MenuWithIngredientsService {
    MenuWithIngredientsSummarized save(MenuWithIngredientsDto menuWithIngredientsDto);
    List<MenuWithIngredientsSummarized> findAll();
    void delete(Long id);
}
