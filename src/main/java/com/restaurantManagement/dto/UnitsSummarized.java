package com.restaurantManagement.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UnitsSummarized {
    private Long id;
    private String name;
    private String abbreviation;
    private Instant createdAt;
    private Instant updatedAt;
}
