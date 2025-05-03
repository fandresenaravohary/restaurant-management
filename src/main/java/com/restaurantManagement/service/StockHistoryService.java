package com.restaurantManagement.service;

import com.restaurantManagement.summarized.StockHistorySummarized;

import java.util.List;

public interface StockHistoryService {
    List<StockHistorySummarized> findAll();
}
