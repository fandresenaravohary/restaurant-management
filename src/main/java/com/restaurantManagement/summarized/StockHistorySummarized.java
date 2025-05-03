package com.restaurantManagement.summarized;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StockHistorySummarized {
    private Long id;
    private Long stockId;
    private String operationType;
    private Double quantity;
    private Instant date;
    private Instant createdAt;
    private Instant updatedAt;
}
