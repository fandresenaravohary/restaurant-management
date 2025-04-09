package com.restaurantManagement.service;

import com.restaurantManagement.dto.IngredientsDto;
import com.restaurantManagement.dto.IngredientsSummarized;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IngredientsService {
    IngredientsSummarized save(IngredientsDto ingredientsDto);
    List<IngredientsSummarized> findAll();
    void delete(Long id);
}
