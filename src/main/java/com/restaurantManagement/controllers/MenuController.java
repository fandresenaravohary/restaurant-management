package com.restaurantManagement.controllers;

import com.restaurantManagement.dto.MenuDto;
import com.restaurantManagement.service.MenuService;
import com.restaurantManagement.summarized.MenuSummarized;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/menu")
@RequiredArgsConstructor
public class MenuController {

    private final MenuService menuService;

    @PostMapping
    public ResponseEntity<MenuSummarized> createOrUpdateMenu(@Valid @RequestBody MenuDto menuDto) {
        MenuSummarized savedMenu = menuService.save(menuDto);

        HttpStatus status = (menuDto.getId() == null) ? HttpStatus.CREATED : HttpStatus.OK;

        return ResponseEntity.status(status).body(savedMenu);
    }

    @GetMapping
    public ResponseEntity<List<MenuSummarized>> findAllMenus() {
        List<MenuSummarized> menus = menuService.findAll();
        return ResponseEntity.ok(menus);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMenu(@PathVariable Long id) {
        menuService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

