package com.restaurantManagement.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Data
@Builder
public class StockHistoryDto {
    private Long id;

    @NotNull(message = "Stock ID is required")
    private Long stockId;

    @NotNull(message = "provide the operation's type")
    private String operationType;

    @NotNull(message = "Quantity is required")
    private Double quantity;

    @NotNull(message = "Date is required")
    private Instant date;
}
