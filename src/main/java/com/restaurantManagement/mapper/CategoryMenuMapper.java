package com.restaurantManagement.mapper;

import com.restaurantManagement.dto.CategoryMenuDto;
import com.restaurantManagement.summarized.CategoryMenuSummarized;
import com.restaurantManagement.models.CategoryMenu;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CategoryMenuMapper {

    public CategoryMenuSummarized convertToCategoryMenuSummarized(CategoryMenu categoryMenu) {
        if(categoryMenu == null) {
            return null;
        }
        return CategoryMenuSummarized.builder()
                .id(categoryMenu.getId())
                .name(categoryMenu.getName())
                .description(categoryMenu.getDescription())
                .createdAt(categoryMenu.getCreatedAt())
                .updatedAt(categoryMenu.getUpdatedAt())
                .build();
    }

    public CategoryMenu convertToCategoryMenu(CategoryMenuDto categoryMenuDto) {
        if(categoryMenuDto == null) {
            return null;
        }
        return  CategoryMenu.builder()
                .id(categoryMenuDto.getId())
                .name(categoryMenuDto.getName())
                .description(categoryMenuDto.getDescription())
                .build();
    }

}
