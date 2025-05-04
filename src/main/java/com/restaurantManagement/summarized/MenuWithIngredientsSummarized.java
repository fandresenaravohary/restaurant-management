package com.restaurantManagement.summarized;

import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Data
@Builder
public class MenuWithIngredientsSummarized {
    private Long id;
    private String menuName;
    private String ingredientName;
    private Double quantity;
    private Instant createdAt;
    private Instant updatedAt;
}
