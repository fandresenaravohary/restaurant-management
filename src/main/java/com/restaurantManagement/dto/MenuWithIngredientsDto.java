package com.restaurantManagement.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MenuWithIngredientsDto {
    private Long id;

    @NotNull(message = "Menu ID is required")
    private Long menuId;

    @NotNull(message = "Ingredients ID is required")
    private Long ingredientId;

    private Double quantity;

}
