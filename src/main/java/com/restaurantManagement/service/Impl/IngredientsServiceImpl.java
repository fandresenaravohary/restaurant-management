package com.restaurantManagement.service.Impl;

import com.restaurantManagement.dto.IngredientsDto;
import com.restaurantManagement.models.Stock;
import com.restaurantManagement.repository.StockRepository;
import com.restaurantManagement.service.IngredientsService;
import com.restaurantManagement.summarized.IngredientsSummarized;
import com.restaurantManagement.mapper.IngredientsMapper;
import com.restaurantManagement.models.Ingredients;
import com.restaurantManagement.repository.IngredientsRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IngredientsServiceImpl implements IngredientsService {

    private final IngredientsRepository ingredientsRepository;
    private final IngredientsMapper ingredientsMapper;
    private final StockRepository stockRepository;

    @Override
    @Transactional
    public IngredientsSummarized save(IngredientsDto ingredientsDto) {
        Ingredients ingredients = ingredientsMapper.convertToIngredients(ingredientsDto);
        Ingredients saved = ingredientsRepository.save(ingredients);
        if (ingredientsDto.getId() == null) {
            Stock stock = Stock.builder()
                    .ingredient(saved)
                    .quantity(0.0)
                    .build();
            Stock savedStock = stockRepository.save(stock);

            saved.setStock(savedStock);
        }


        Ingredients reloaded = ingredientsRepository.findById(saved.getId())
                .orElseThrow(() -> new RuntimeException("Ingredients not found after save"));

        return ingredientsMapper.convertToIngredientsSummarized(reloaded);
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
