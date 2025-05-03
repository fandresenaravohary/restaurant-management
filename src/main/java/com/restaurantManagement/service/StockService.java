package com.restaurantManagement.service;

import com.restaurantManagement.dto.StockDto;
import com.restaurantManagement.summarized.StockSummarized;

import java.util.List;

public interface StockService {
    StockSummarized save(StockDto stockDto);
    List<StockSummarized> findAll();
    void delete(Long id);
}
