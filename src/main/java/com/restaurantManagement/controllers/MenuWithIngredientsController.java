package com.restaurantManagement.controllers;

import com.restaurantManagement.dto.MenuWithIngredientsDto;
import com.restaurantManagement.service.MenuWithIngredientsService;
import com.restaurantManagement.summarized.MenuWithIngredientsSummarized;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/menu-ingredients")
@RequiredArgsConstructor
public class MenuWithIngredientsController {

    private final MenuWithIngredientsService menuWithIngredientsService;

    @PostMapping
    public ResponseEntity<MenuWithIngredientsSummarized> createOrUpdate(@Valid @RequestBody MenuWithIngredientsDto dto) {
        MenuWithIngredientsSummarized saved = menuWithIngredientsService.save(dto);
        HttpStatus status = (dto.getId() == null) ? HttpStatus.CREATED : HttpStatus.OK;
        return ResponseEntity.status(status).body(saved);
    }

    @GetMapping
    public ResponseEntity<List<MenuWithIngredientsSummarized>> findAll() {
        List<MenuWithIngredientsSummarized> list = menuWithIngredientsService.findAll();
        return ResponseEntity.ok(list);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        menuWithIngredientsService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

