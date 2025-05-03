package com.restaurantManagement.service;

import com.restaurantManagement.dto.StockHistoryDto;
import com.restaurantManagement.dto.StockHistorySummarized;

import java.util.List;

public interface StockHistoryService {
    StockHistorySummarized save(StockHistoryDto stockHistoryDto);
    List<StockHistorySummarized> findAll();
    void delete(Long id);
}
