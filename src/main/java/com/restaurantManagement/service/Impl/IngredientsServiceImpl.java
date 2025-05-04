package com.restaurantManagement.service.Impl;

import com.restaurantManagement.dto.IngredientsDto;
import com.restaurantManagement.models.Stock;
import com.restaurantManagement.models.StockHistory;
import com.restaurantManagement.repository.*;
import com.restaurantManagement.service.IngredientsService;
import com.restaurantManagement.summarized.IngredientsSummarized;
import com.restaurantManagement.mapper.IngredientsMapper;
import com.restaurantManagement.models.Ingredients;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
@RequiredArgsConstructor
public class IngredientsServiceImpl implements IngredientsService {

    private final IngredientsRepository ingredientsRepository;
    private final IngredientsMapper ingredientsMapper;
    private final StockRepository stockRepository;
    private final StockHistoryRepository stockHistoryRepository;
    private final UnitsRepository unitsRepository;
    private final CategoryIngredientsRepository categoryIngredientsRepository;

    @Override
    @Transactional
    public IngredientsSummarized save(IngredientsDto ingredientsDto) {
        Ingredients saved;

        if (ingredientsDto.getId() == null) {
            Ingredients ingredients = ingredientsMapper.convertToIngredients(ingredientsDto);

            ingredients.setUnits(unitsRepository.findById(ingredientsDto.getUnitsId())
                    .orElseThrow(() -> new RuntimeException("Unité non trouvée")));
            ingredients.setCategoryIngredients(categoryIngredientsRepository.findById(ingredientsDto.getCategoryIngredientsId())
                    .orElseThrow(() -> new RuntimeException("Catégorie non trouvée")));

            saved = ingredientsRepository.save(ingredients);

            Stock stock = Stock.builder()
                    .ingredient(saved)
                    .quantity(0.0)
                    .build();
            Stock savedStock = stockRepository.save(stock);

            saved.setStock(savedStock);

            StockHistory stockHistory = StockHistory.builder()
                    .stock(savedStock)
                    .operationType("CREATE")
                    .quantity(0.0)
                    .date(Instant.now())
                    .build();
            stockHistoryRepository.save(stockHistory);

        } else {
            Ingredients existing = ingredientsRepository.findById(ingredientsDto.getId())
                    .orElseThrow(() -> new RuntimeException("Ingrédient non trouvé"));

            existing.setName(ingredientsDto.getName());
            existing.setDescription(ingredientsDto.getDescription());
            existing.setUrl(ingredientsDto.getUrl());

            existing.setUnits(unitsRepository.findById(ingredientsDto.getUnitsId())
                    .orElseThrow(() -> new RuntimeException("Unité non trouvée")));
            existing.setCategoryIngredients(categoryIngredientsRepository.findById(ingredientsDto.getCategoryIngredientsId())
                    .orElseThrow(() -> new RuntimeException("Catégorie non trouvée")));

            saved = ingredientsRepository.save(existing);

            Stock stock = stockRepository.findByIngredientId(saved.getId())
                    .orElseThrow(() -> new RuntimeException("Stock non trouvé pour cet ingrédient"));

            StockHistory stockHistory = StockHistory.builder()
                    .stock(stock)
                    .operationType("UPDATE")
                    .quantity(stock.getQuantity())
                    .date(Instant.now())
                    .build();
            stockHistoryRepository.save(stockHistory);
        }

        return ingredientsMapper.convertToIngredientsSummarized(saved);
    }

    @Override
    public List<IngredientsSummarized> findAll() {
        return ingredientsRepository.findAllIngredientsSummarized();
    }

    @Override
    public void delete(Long id) {
        ingredientsRepository.deleteById(id);
    }
}
