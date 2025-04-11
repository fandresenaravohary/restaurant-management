package com.restaurantManagement.mapper;

import com.restaurantManagement.dto.StockHistoryDto;
import com.restaurantManagement.dto.StockHistorySummarized;
import com.restaurantManagement.models.Stock;
import com.restaurantManagement.models.StockHistory;
import com.restaurantManagement.repository.StockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StockHistoryMapper {

    private final StockRepository stockRepository;

    public StockHistorySummarized convertToStockHistorySummarized(StockHistory stockHistory) {
        if (stockHistory == null) {
            return null;
        }
        return StockHistorySummarized.builder()
                .id(stockHistory.getId())
                .stockId(stockHistory.getStock() != null ? stockHistory.getStock().getId() : null)
                .operationType(stockHistory.getOperationType())
                .date(stockHistory.getDate())
                .quantity(stockHistory.getQuantity())
                .createdAt(stockHistory.getCreatedAt())
                .updatedAt(stockHistory.getUpdatedAt())
                .build();
    }

    public StockHistory convertToStockHistory(StockHistoryDto stockHistoryDto) {
        if (stockHistoryDto == null) {
            return null;
        }

        Stock stockId = stockRepository.findById(stockHistoryDto.getStockId())
                .orElseThrow(() -> new RuntimeException("Stock not found for id: " + stockHistoryDto.getStockId()));

        return StockHistory.builder()
                .id(stockHistoryDto.getId())
                .stock(stockId)
                .operationType(stockHistoryDto.getOperationType())
                .quantity(stockHistoryDto.getQuantity())
                .date(stockHistoryDto.getDate())
                .build();
    }
}
