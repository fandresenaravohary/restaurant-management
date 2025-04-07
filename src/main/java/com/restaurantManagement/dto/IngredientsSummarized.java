package com.restaurantManagement.dto;

import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Data
@Builder
public class IngredientsSummarized {
    private Long id;
    private String name;
    private String url;
    private String unitsName;
    private String categoryIngredientsName;
    private Instant createdAt;
    private Instant updatedAt;
}
