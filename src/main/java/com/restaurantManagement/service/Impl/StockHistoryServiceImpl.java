package com.restaurantManagement.service.Impl;

import com.restaurantManagement.dto.StockHistoryDto;
import com.restaurantManagement.service.StockHistoryService;
import com.restaurantManagement.summarized.StockHistorySummarized;
import com.restaurantManagement.mapper.StockHistoryMapper;
import com.restaurantManagement.models.StockHistory;
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
    public StockHistorySummarized save(StockHistoryDto stockHistoryDto) {
        StockHistory stockHistory = stockHistoryMapper.convertToStockHistory(stockHistoryDto);
        StockHistory saved = stockHistoryRepository.save(stockHistory);
        return stockHistoryMapper.convertToStockHistorySummarized(saved);
    }

    @Override
    public List<StockHistorySummarized> findAll() {
        return stockHistoryRepository.findAll()
                .stream()
                .map(stockHistoryMapper::convertToStockHistorySummarized)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        if (!stockHistoryRepository.existsById(id)) {
            throw new RuntimeException("Stock not found with id: " + id);
        }
        stockHistoryRepository.deleteById(id);
    }
}
