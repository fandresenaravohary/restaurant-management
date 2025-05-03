package com.restaurantManagement.summarized;

import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Data
@Builder
public class MenuSummarized {
    private Long id;
    private String name;
    private int currentPrice;
    private String url;
    private String description;
    private String categoryMenuName;
    private Instant createdAt;
    private Instant updatedAt;
}
