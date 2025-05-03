package com.restaurantManagement.summarized;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StockSummarized {
    private Long id;
    private String ingredientName;
    private Double quantity;
    private Instant createdAt;
    private Instant updatedAt;
}
