package com.restaurantManagement.service;

import com.restaurantManagement.dto.StockDto;
import com.restaurantManagement.summarized.StockSummarized;

import java.util.List;

public interface StockService {
    List<StockSummarized> findAll();
}
