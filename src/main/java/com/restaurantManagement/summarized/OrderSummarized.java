package com.restaurantManagement.summarized;

import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Data
@Builder
public class OrderSummarized {
    private Long id;
    private int tableNumber;
    private String menuName;
    private int price;
    private Double quantity;
    private Instant createdAt;
    private Instant updatedAt;
}
