package com.restaurantManagement.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MenuDto {

    private Long id;

    @NotNull(message = "Name is required")
    @Size(min = 2, max = 10, message = "Name must be between 2 and 10 characters")
    private String name;

    @Min(value = 0, message = "Current price must be positive")
    private int currentPrice;

    private String description;

    private String url;

    @NotNull(message = "Category ID is required")
    private Long categoryMenuId;
}
