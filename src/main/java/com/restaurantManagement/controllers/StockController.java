package com.restaurantManagement.controllers;

import com.restaurantManagement.dto.StockDto;
import com.restaurantManagement.summarized.StockSummarized;
import com.restaurantManagement.service.StockService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stocks")
@RequiredArgsConstructor
public class StockController {

    private final StockService stockService;

    @PostMapping
    public ResponseEntity<StockSummarized> createOrUpdateStock(@Valid @RequestBody StockDto stockDto) {
        StockSummarized savedStock = stockService.save(stockDto);

        HttpStatus status = (stockDto.getId() == null) ? HttpStatus.CREATED : HttpStatus.OK;

        return ResponseEntity.status(status).body(savedStock);
    }

    @GetMapping
    public ResponseEntity<List<StockSummarized>> findAllStocks() {
        List<StockSummarized> stocks = stockService.findAll();
        return ResponseEntity.ok(stocks);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStock(@PathVariable Long id) {
        stockService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
