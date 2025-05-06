package com.restaurantManagement.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class TableRestaurantDto {
    private Long id;
    private int number;
    private String status;
}
