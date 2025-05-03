package com.restaurantManagement.service;

import com.restaurantManagement.dto.CategoryIngredientsDto;
import com.restaurantManagement.summarized.CategoryIngredientsSummarized;

import java.util.List;

public interface CategoryIngredientsService{
    CategoryIngredientsSummarized save(CategoryIngredientsDto ingredientsDto);
    List<CategoryIngredientsSummarized> findAll();
    void delete(Long id);
}
