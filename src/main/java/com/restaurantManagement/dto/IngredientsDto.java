package com.restaurantManagement.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class IngredientsDto {

    private Long id;

    @NotNull(message = "Name is required")
    @Size(min = 2, max = 10, message = "Name must be between 2 and 10 characters")
    private String name;

    private String description;

    private String url;

    @NotNull(message = "Unit ID is required")
    private Long unitsId;

    @NotNull(message = "Category ID is required")
    private Long categoryIngredientsId;
}