package com.restaurantManagement.service;

import com.restaurantManagement.dto.StockHistorySummarized;

import java.util.List;

public interface StockHistoryService {
    List<StockHistorySummarized> findAll();
}
