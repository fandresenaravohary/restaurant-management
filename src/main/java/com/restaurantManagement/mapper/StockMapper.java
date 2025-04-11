package com.restaurantManagement.mapper;

import com.restaurantManagement.dto.StockDto;
import com.restaurantManagement.dto.StockSummarized;
import com.restaurantManagement.models.Ingredients;
import com.restaurantManagement.models.Stock;
import com.restaurantManagement.repository.IngredientsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StockMapper {

    private final IngredientsRepository ingredientsRepository;

    public StockSummarized convertToStockSummarized(Stock stock) {
        if(stock == null) {
            return null;
        }
        return StockSummarized.builder()
                .id(stock.getId())
                .ingredientName(stock.getIngredient() != null ? stock.getIngredient().getName() : null)
                .quantity(stock.getQuantity())
                .createdAt(stock.getCreatedAt())
                .updatedAt(stock.getUpdatedAt())
                .build();
    }

    public Stock convertToStock(StockDto stockDto){
        if(stockDto == null) {
            return null;
        }

        Ingredients ingredientsId = ingredientsRepository.findById(stockDto.getIngredientId())
                .orElseThrow(() -> new RuntimeException("Ingredient not found for id: " + stockDto.getIngredientId()));

        return Stock.builder()
                .id(stockDto.getId())
                .ingredient(ingredientsId)
                .quantity(stockDto.getQuantity())
                .build();
    }
}
