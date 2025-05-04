package com.restaurantManagement.service;

import com.restaurantManagement.dto.StockDto;
import com.restaurantManagement.summarized.StockSummarized;

import java.util.List;

public interface StockService {
    void addStock(Long ingredientId, double quantity);
    List<StockSummarized> findAll();
}
