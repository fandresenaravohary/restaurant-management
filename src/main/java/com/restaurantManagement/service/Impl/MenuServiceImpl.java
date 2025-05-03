package com.restaurantManagement.service.Impl;

import com.restaurantManagement.dto.MenuDto;
import com.restaurantManagement.mapper.MenuMapper;
import com.restaurantManagement.models.Menu;
import com.restaurantManagement.repository.MenuRepository;
import com.restaurantManagement.service.MenuService;
import com.restaurantManagement.summarized.MenuSummarized;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MenuServiceImpl implements MenuService {

    private final MenuRepository menuRepository;
    private final MenuMapper menuMapper;

    @Override
    public MenuSummarized save(MenuDto menuDto) {
        Menu menu = menuMapper.convertToMenu(menuDto);
        Menu saved = menuRepository.save(menu);
        return menuMapper.convertToMenuSummarized(saved);
    }

    @Override
    public List<MenuSummarized> findAll() {
        return menuRepository.findAll()
                .stream()
                .map(menuMapper::convertToMenuSummarized)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        if (!menuRepository.existsById(id)) {
            throw new RuntimeException("Menu not found with id: " + id);
        }
        menuRepository.deleteById(id);
    }
}

