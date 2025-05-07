package com.restaurantManagement.dto;

import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Data
@Builder
public class OrderDto {
    private Long id;
    private int price;
    private Double quantity;
    private Long menuId;
    private Long tableId;
}
