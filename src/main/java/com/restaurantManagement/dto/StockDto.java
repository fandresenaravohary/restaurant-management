package com.restaurantManagement.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StockDto {
    private Long id;

    @NotNull(message = "Ingredients ID is required")
    private Long ingredientId;

    private Double quantity;
}
