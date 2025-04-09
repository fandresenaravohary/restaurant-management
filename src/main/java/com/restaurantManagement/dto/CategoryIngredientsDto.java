package com.restaurantManagement.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryIngredientsDto {

    private Long id;

    @NotNull(message = "Name is required")
    @Size(min = 1, max = 10, message = "Name must be between 1 and 10 characters")
    private String name;

    @NotNull(message = "Abbreviation is required")
    @Size(min = 1, max = 10, message = "Abbreviation must be between 1 and 10 characters")
    private String abbreviation;
}
