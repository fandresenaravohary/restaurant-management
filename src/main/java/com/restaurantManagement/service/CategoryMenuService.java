package com.restaurantManagement.service;

import com.restaurantManagement.dto.CategoryMenuDto;
import com.restaurantManagement.summarized.CategoryMenuSummarized;

import java.util.List;

public interface CategoryMenuService {
    CategoryMenuSummarized save(CategoryMenuDto categoryMenuDto);
    List<CategoryMenuSummarized> findAll();
    void delete(Long id);
}
