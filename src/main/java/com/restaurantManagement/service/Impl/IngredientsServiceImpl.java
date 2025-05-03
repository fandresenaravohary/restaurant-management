package com.restaurantManagement.service.Impl;

import com.restaurantManagement.dto.IngredientsDto;
import com.restaurantManagement.service.IngredientsService;
import com.restaurantManagement.summarized.IngredientsSummarized;
import com.restaurantManagement.mapper.IngredientsMapper;
import com.restaurantManagement.models.Ingredients;
import com.restaurantManagement.repository.IngredientsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IngredientsServiceImpl implements IngredientsService {

    private final IngredientsRepository ingredientsRepository;
    private final IngredientsMapper ingredientsMapper;

    @Override
    public IngredientsSummarized save(IngredientsDto ingredientsDto) {
        Ingredients ingredients = ingredientsMapper.convertToIngredients(ingredientsDto);
        Ingredients saved = ingredientsRepository.save(ingredients);
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
