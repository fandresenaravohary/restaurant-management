package com.restaurantManagement.dto;

import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Data
@Builder
public class OrderDto {
    private Long id;
    private Double buyingPrice;
    private Integer quantity;
    private Instant orderTime;
    private String status;
}
