package com.restaurantManagement.mapper;

import com.restaurantManagement.dto.MenuDto;
import com.restaurantManagement.models.CategoryIngredients;
import com.restaurantManagement.models.CategoryMenu;
import com.restaurantManagement.models.Menu;
import com.restaurantManagement.repository.CategoryMenuRepository;
import com.restaurantManagement.summarized.MenuSummarized;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MenuMapper {

    private final CategoryMenuRepository categoryMenuRepository;

    public MenuSummarized convertToMenuSummarized(Menu menu) {
        if (menu == null) {
            return null;
        }
        return MenuSummarized.builder()
                .id(menu.getId())
                .name(menu.getName())
                .description(menu.getDescription())
                .currentPrice(menu.getCurrentPrice())
                .url(menu.getUrl())
                .categoryMenuName(menu.getCategoryMenu() != null ? menu.getCategoryMenu().getName() : null)
                .createdAt(menu.getCreatedAt())
                .updatedAt(menu.getUpdatedAt())
                .build();
    }

    public Menu convertToMenu(MenuDto menuDto) {
        if (menuDto == null) {
            return null;
        }
        CategoryMenu categoryMenuId = categoryMenuRepository.findById(menuDto.getCategoryMenuId())
                .orElseThrow(() -> new RuntimeException("Category menu not found for id: " + menuDto.getCategoryMenuId()));

        return Menu.builder()
                .id(menuDto.getId())
                .name(menuDto.getName())
                .description(menuDto.getDescription())
                .url(menuDto.getUrl())
                .currentPrice(menuDto.getCurrentPrice())
                .categoryMenu(categoryMenuId)
                .build();
    }
}
