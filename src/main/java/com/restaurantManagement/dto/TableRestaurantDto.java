package com.restaurantManagement.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class TableRestaurantDto {
    private Long id;
    private int numberTable;
    private int capacityMax;
    private String status;
}
