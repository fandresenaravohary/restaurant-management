package com.restaurantManagement.service.Impl;

import com.restaurantManagement.models.StockHistory;
import com.restaurantManagement.repository.StockHistoryRepository;
import com.restaurantManagement.service.StockService;
import com.restaurantManagement.summarized.StockSummarized;
import com.restaurantManagement.mapper.StockMapper;
import com.restaurantManagement.models.Stock;
import com.restaurantManagement.repository.StockRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StockServiceImpl implements StockService {

    private final StockRepository stockRepository;
    private final StockMapper stockMapper;
    private final StockHistoryRepository stockHistoryRepository;

    @Override
    @Transactional
    public void addStock(Long ingredientId, double quantity) {

        Stock stock = stockRepository.findByIngredientId(ingredientId)
                .orElseThrow(() -> new RuntimeException("Stock not found for ingredient ID: " + ingredientId));

        stock.setQuantity(stock.getQuantity() + quantity);
        stockRepository.save(stock);

        StockHistory stockHistory = StockHistory.builder()
                .stock(stock)
                .operationType("ADD")
                .quantity(quantity)
                .date(Instant.now())
                .build();
        stockHistoryRepository.save(stockHistory);
    }


    @Override
    public List<StockSummarized> findAll() {
        return stockRepository.findAll()
                .stream()
                .map(stockMapper::convertToStockSummarized)
                .collect(Collectors.toList());
    }
}

