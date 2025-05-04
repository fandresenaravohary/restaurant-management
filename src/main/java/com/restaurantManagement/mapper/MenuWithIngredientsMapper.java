package com.restaurantManagement.mapper;

import com.restaurantManagement.dto.MenuWithIngredientsDto;
import com.restaurantManagement.models.Ingredients;
import com.restaurantManagement.models.Menu;
import com.restaurantManagement.models.MenuWithIngredients;
import com.restaurantManagement.repository.IngredientsRepository;
import com.restaurantManagement.repository.MenuRepository;
import com.restaurantManagement.summarized.MenuWithIngredientsSummarized;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MenuWithIngredientsMapper {

    private final MenuRepository menuRepository;
    private final IngredientsRepository ingredientsRepository;

    public MenuWithIngredientsSummarized convertToMenuWithIngredientsSummarized(MenuWithIngredients menuWithIngredients) {
        if (menuWithIngredients == null) {
            return null;
        }
        return MenuWithIngredientsSummarized.builder()
                .id(menuWithIngredients.getId())
                .menuName(menuWithIngredients.getMenu() != null ? menuWithIngredients.getMenu().getName() : null)
                .ingredientName(menuWithIngredients.getIngredient() != null ? menuWithIngredients.getIngredient().getName() : null)
                .quantity(menuWithIngredients.getQuantity())
                .createdAt(menuWithIngredients.getCreatedAt())
                .updatedAt(menuWithIngredients.getUpdatedAt())
                .build();
    }

    public MenuWithIngredients convertToMenuWithIngredients(MenuWithIngredientsDto menuWithIngredientsDto) {
        if (menuWithIngredientsDto == null) {
            return null;
        }

        Menu menuId = menuRepository.findById(menuWithIngredientsDto.getMenuId())
                .orElseThrow(() -> new RuntimeException("Menu not found for id " + menuWithIngredientsDto.getMenuId()));

        Ingredients ingredientsId = ingredientsRepository.findById(menuWithIngredientsDto.getIngredientId())
                .orElseThrow(() -> new RuntimeException("Ingredients not found for id " + menuWithIngredientsDto.getIngredientId()));

        return MenuWithIngredients.builder()
                .id(menuWithIngredientsDto.getId())
                .menu(menuId)
                .ingredient(ingredientsId)
                .quantity(menuWithIngredientsDto.getQuantity())
                .build();
    }

}
