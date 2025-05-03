package com.restaurantManagement.service.Impl;

import com.restaurantManagement.dto.CategoryMenuDto;
import com.restaurantManagement.service.CategoryMenuService;
import com.restaurantManagement.summarized.CategoryMenuSummarized;
import com.restaurantManagement.mapper.CategoryMenuMapper;
import com.restaurantManagement.models.CategoryMenu;
import com.restaurantManagement.repository.CategoryMenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryMenuImpl implements CategoryMenuService {

    private final CategoryMenuMapper categoryMenuMapper;
    private final CategoryMenuRepository categoryMenuRepository;

    @Override
    public CategoryMenuSummarized save(CategoryMenuDto categoryMenuDto) {
        CategoryMenu categoryMenu = categoryMenuMapper.convertToCategoryMenu(categoryMenuDto);
        CategoryMenu savedCategoryMenu = categoryMenuRepository.save(categoryMenu);
        return categoryMenuMapper.convertToCategoryMenuSummarized(savedCategoryMenu);
    }

    @Override
    public List<CategoryMenuSummarized> findAll() {
        return categoryMenuRepository.findAll()
                .stream()
                .map(categoryMenuMapper::convertToCategoryMenuSummarized)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        if (categoryMenuRepository.existsById(id)) {
            categoryMenuRepository.deleteById(id);
        }
        else {
            throw new RuntimeException("Category Menu Not Found: "+ id);
        }
    }
}
