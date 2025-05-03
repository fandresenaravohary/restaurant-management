package com.restaurantManagement.service.Impl;

import com.restaurantManagement.dto.StockDto;
import com.restaurantManagement.service.StockService;
import com.restaurantManagement.summarized.StockSummarized;
import com.restaurantManagement.mapper.StockMapper;
import com.restaurantManagement.models.Stock;
import com.restaurantManagement.repository.StockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StockServiceImpl implements StockService {

    private final StockRepository stockRepository;
    private final StockMapper stockMapper;

    @Override
    public StockSummarized save(StockDto stockDto) {
        Stock stock = stockMapper.convertToStock(stockDto);
        Stock saved = stockRepository.save(stock);
        return stockMapper.convertToStockSummarized(saved);
    }

    @Override
    public List<StockSummarized> findAll() {
        return stockRepository.findAll()
                .stream()
                .map(stockMapper::convertToStockSummarized)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        if (!stockRepository.existsById(id)) {
            throw new RuntimeException("Stock not found with id: " + id);
        }
        stockRepository.deleteById(id);
    }
}

