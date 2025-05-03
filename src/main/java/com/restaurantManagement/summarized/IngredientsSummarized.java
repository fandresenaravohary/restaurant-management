package com.restaurantManagement.summarized;

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
    private Long stockId;
    private Double stockQuantity;
    private Instant createdAt;
    private Instant updatedAt;
}
