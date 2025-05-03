package com.restaurantManagement.controllers;

import com.restaurantManagement.dto.StockHistoryDto;
import com.restaurantManagement.dto.StockHistorySummarized;
import com.restaurantManagement.service.StockHistoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stock-histories")
@RequiredArgsConstructor
public class StockHistoryController {

    private final StockHistoryService stockHistoryService;

    @PostMapping
    public ResponseEntity<StockHistorySummarized> createOrUpdateStockHistory(@Valid @RequestBody StockHistoryDto stockHistoryDto) {
        StockHistorySummarized savedHistory = stockHistoryService.save(stockHistoryDto);
        HttpStatus status = (stockHistoryDto.getId() == null) ? HttpStatus.CREATED : HttpStatus.OK;
        return ResponseEntity.status(status).body(savedHistory);
    }

    @GetMapping
    public ResponseEntity<List<StockHistorySummarized>> findAllStockHistories() {
        List<StockHistorySummarized> histories = stockHistoryService.findAll();
        return ResponseEntity.ok(histories);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStockHistory(@PathVariable Long id) {
        stockHistoryService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
