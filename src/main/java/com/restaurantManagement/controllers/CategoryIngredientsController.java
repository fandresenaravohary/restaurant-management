package com.restaurantManagement.controllers;

import com.restaurantManagement.dto.CategoryIngredientsDto;
import com.restaurantManagement.summarized.CategoryIngredientsSummarized;
import com.restaurantManagement.service.CategoryIngredientsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category-ingredients")
@RequiredArgsConstructor
public class CategoryIngredientsController {

    private final CategoryIngredientsService categoryIngredientsService;

    @PostMapping
    public ResponseEntity<CategoryIngredientsSummarized> createOrUpdate(@Valid @RequestBody CategoryIngredientsDto categoryIngredientsDto) {
        CategoryIngredientsSummarized savedCategory = categoryIngredientsService.save(categoryIngredientsDto);

        HttpStatus status = (categoryIngredientsDto.getId() == null) ? HttpStatus.CREATED : HttpStatus.OK;

        return ResponseEntity.status(status).body(savedCategory);
    }

    @GetMapping
    public ResponseEntity<List<CategoryIngredientsSummarized>> findAll() {
        List<CategoryIngredientsSummarized> categories = categoryIngredientsService.findAll();
        return ResponseEntity.ok(categories);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        categoryIngredientsService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
