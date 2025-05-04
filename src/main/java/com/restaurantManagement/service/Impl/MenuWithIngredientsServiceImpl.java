package com.restaurantManagement.service.Impl;

import com.restaurantManagement.dto.MenuWithIngredientsDto;
import com.restaurantManagement.mapper.MenuWithIngredientsMapper;
import com.restaurantManagement.models.MenuWithIngredients;
import com.restaurantManagement.repository.MenuWithIngredientsRepository;
import com.restaurantManagement.service.MenuWithIngredientsService;
import com.restaurantManagement.summarized.MenuWithIngredientsSummarized;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MenuWithIngredientsServiceImpl implements MenuWithIngredientsService {

    private final MenuWithIngredientsRepository menuWithIngredientsRepository;
    private final MenuWithIngredientsMapper menuWithIngredientsMapper;

    @Override
    public MenuWithIngredientsSummarized save(MenuWithIngredientsDto menuWithIngredientsDto) {
        MenuWithIngredients entity = menuWithIngredientsMapper.convertToMenuWithIngredients(menuWithIngredientsDto);
        MenuWithIngredients saved = menuWithIngredientsRepository.save(entity);
        return menuWithIngredientsMapper.convertToMenuWithIngredientsSummarized(saved);
    }

    @Override
    public List<MenuWithIngredientsSummarized> findAll() {
        return menuWithIngredientsRepository.findAll()
                .stream()
                .map(menuWithIngredientsMapper::convertToMenuWithIngredientsSummarized)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        if (!menuWithIngredientsRepository.existsById(id)) {
            throw new RuntimeException("MenuWithIngredients not found with id: " + id);
        }
        menuWithIngredientsRepository.deleteById(id);
    }
}

