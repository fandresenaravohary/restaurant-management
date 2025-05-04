package com.restaurantManagement.mapper;

import com.restaurantManagement.dto.CategoryIngredientsDto;
import com.restaurantManagement.summarized.CategoryIngredientsSummarized;
import com.restaurantManagement.models.CategoryIngredients;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CategoryIngredientsMapper {

    public CategoryIngredientsSummarized convertToCategoryIngredientsSummarized(CategoryIngredients categoryIngredients) {
        if(categoryIngredients == null){
            return null;
        }
        return CategoryIngredientsSummarized.builder()
                .id(categoryIngredients.getId())
                .name(categoryIngredients.getName())
                .description(categoryIngredients.getDescription())
                .createdAt(categoryIngredients.getCreatedAt())
                .updatedAt(categoryIngredients.getUpdatedAt())
                .build();
    }

    public CategoryIngredients convertToCategoryIngredients(CategoryIngredientsDto categoryIngredientsDto) {
        if(categoryIngredientsDto == null){
            return null;
        }
        return CategoryIngredients.builder()
                .id(categoryIngredientsDto.getId())
                .name(categoryIngredientsDto.getName())
                .description(categoryIngredientsDto.getDescription())
                .build();
    }
}
