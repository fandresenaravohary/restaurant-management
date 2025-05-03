package com.restaurantManagement.mapper;

import com.restaurantManagement.dto.IngredientsDto;
import com.restaurantManagement.summarized.IngredientsSummarized;
import com.restaurantManagement.models.CategoryIngredients;
import com.restaurantManagement.models.Ingredients;
import com.restaurantManagement.models.Units;
import com.restaurantManagement.repository.CategoryIngredientsRepository;
import com.restaurantManagement.repository.UnitsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class IngredientsMapper {

    private final UnitsRepository unitsRepository;
    private final CategoryIngredientsRepository categoryIngredientsRepository;

    public IngredientsSummarized convertToIngredientsSummarized(Ingredients ingredients) {
        if (ingredients == null) {
            return null;
        }
        return IngredientsSummarized.builder()
                .id(ingredients.getId())
                .name(ingredients.getName())
                .url(ingredients.getUrl())
                .unitsName(ingredients.getUnits() != null ? ingredients.getUnits().getName() : null)
                .categoryIngredientsName(ingredients.getCategoryIngredients() != null ? ingredients.getCategoryIngredients().getName() : null)
                .stockId(ingredients.getStock() != null ? ingredients.getStock().getId() : null)
                .stockQuantity(ingredients.getStock() != null ? ingredients.getStock().getQuantity() : null)
                .createdAt(ingredients.getCreatedAt())
                .updatedAt(ingredients.getUpdatedAt())
                .build();
    }

    public Ingredients convertToIngredients(IngredientsDto ingredientsDto) {
        if (ingredientsDto == null) {
            return null;
        }
        Units unitsId = unitsRepository.findById(ingredientsDto.getUnitsId())
                .orElseThrow(() -> new RuntimeException("Unit not found for id: " + ingredientsDto.getUnitsId()));

        CategoryIngredients categoryIngredientsId = categoryIngredientsRepository.findById(ingredientsDto.getCategoryIngredientsId())
                .orElseThrow(() -> new RuntimeException("Category ingredients not found for id: " + ingredientsDto.getCategoryIngredientsId()));

        return Ingredients.builder()
                .id(ingredientsDto.getId())
                .name(ingredientsDto.getName())
                .description(ingredientsDto.getDescription())
                .url(ingredientsDto.getUrl())
                .units(unitsId)
                .categoryIngredients(categoryIngredientsId)
                .build();
    }
}
