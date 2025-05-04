package com.restaurantManagement.service.Impl;

import com.restaurantManagement.service.StockHistoryService;
import com.restaurantManagement.summarized.StockHistorySummarized;
import com.restaurantManagement.mapper.StockHistoryMapper;
import com.restaurantManagement.repository.StockHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StockHistoryServiceImpl implements StockHistoryService {

    private final StockHistoryRepository stockHistoryRepository;
    private final StockHistoryMapper stockHistoryMapper;

    @Override
    public List<StockHistorySummarized> findAll() {
        return stockHistoryRepository.findAll()
                .stream()
                .map(stockHistoryMapper::convertToStockHistorySummarized)
                .collect(Collectors.toList());
    }

}
