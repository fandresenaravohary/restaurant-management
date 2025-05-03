package com.restaurantManagement.controllers;

import com.restaurantManagement.summarized.StockHistorySummarized;
import com.restaurantManagement.service.StockHistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stock-histories")
@RequiredArgsConstructor
public class StockHistoryController {

    private final StockHistoryService stockHistoryService;

    @GetMapping
    public ResponseEntity<List<StockHistorySummarized>> findAllStockHistories() {
        List<StockHistorySummarized> histories = stockHistoryService.findAll();
        return ResponseEntity.ok(histories);
    }
}
