package com.restaurantManagement.service.Impl;

import com.restaurantManagement.dto.CategoryIngredientsDto;
import com.restaurantManagement.service.CategoryIngredientsService;
import com.restaurantManagement.summarized.CategoryIngredientsSummarized;
import com.restaurantManagement.mapper.CategoryIngredientsMapper;
import com.restaurantManagement.models.CategoryIngredients;
import com.restaurantManagement.repository.CategoryIngredientsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryIngredientsServiceImpl implements CategoryIngredientsService {

    private final CategoryIngredientsRepository categoryIngredientsRepository;
    private final CategoryIngredientsMapper categoryIngredientsMapper;

    @Override
    public CategoryIngredientsSummarized save(CategoryIngredientsDto categoryIngredientsDto) {
        CategoryIngredients categoryIngredients = categoryIngredientsMapper.convertToCategoryIngredients(categoryIngredientsDto);
        CategoryIngredients savedCategoryIngredients = categoryIngredientsRepository.save(categoryIngredients);
        return categoryIngredientsMapper.convertToCategoryIngredientsSummarized(savedCategoryIngredients);
    }

    @Override
    public List<CategoryIngredientsSummarized> findAll() {
        return categoryIngredientsRepository.findAll()
                .stream()
                .map(categoryIngredientsMapper::convertToCategoryIngredientsSummarized)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        if (categoryIngredientsRepository.existsById(id)) {
            categoryIngredientsRepository.deleteById(id);
        }
        else {
            throw new RuntimeException("Category Ingredient Not Found: "+ id);
        }
    }
}
