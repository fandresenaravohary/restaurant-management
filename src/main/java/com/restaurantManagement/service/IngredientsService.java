package com.restaurantManagement.service;

import com.restaurantManagement.dto.IngredientsDto;
import com.restaurantManagement.summarized.IngredientsSummarized;

import java.util.List;

public interface IngredientsService {
    IngredientsSummarized save(IngredientsDto ingredientsDto);
    List<IngredientsSummarized> findAll();
    void delete(Long id);
}
