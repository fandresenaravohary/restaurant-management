package com.restaurantManagement.summarized;

import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Data
@Builder
public class TableRestaurantSummarized {
    private Long id;
    private int numberTable;
    private int capacityMax;
    private String status;
    private Instant createdAt;
    private Instant updatedAt;
}
