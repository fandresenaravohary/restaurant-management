package com.restaurantManagement.controllers;

import com.restaurantManagement.summarized.StockSummarized;
import com.restaurantManagement.service.StockService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stocks")
@RequiredArgsConstructor
public class StockController {

    private final StockService stockService;

    @PostMapping("/add")
    public ResponseEntity<Void> addStock(
            @RequestParam Long ingredientId,
            @RequestParam double quantity) {
        stockService.addStock(ingredientId, quantity);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<StockSummarized>> findAllStocks() {
        List<StockSummarized> stocks = stockService.findAll();
        return ResponseEntity.ok(stocks);
    }

}
