package com.restaurantManagement.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UnitsDto {
    private Long id;
    private String name;
    private String abbreviation;
    private Instant createdAt;
    private Instant updatedAt;

    private List<Long> ingredientId;
}
