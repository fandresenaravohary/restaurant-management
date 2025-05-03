package com.restaurantManagement.controllers;

import com.restaurantManagement.dto.CategoryMenuDto;
import com.restaurantManagement.dto.CategoryMenuSummarized;
import com.restaurantManagement.service.CategoryMenuService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category-menu")
@RequiredArgsConstructor
public class CategoryMenuController {

    private final CategoryMenuService categoryMenuService;

    @PostMapping
    public ResponseEntity<CategoryMenuSummarized> createOrUpdate(@Valid @RequestBody CategoryMenuDto categoryMenuDto) {
        CategoryMenuSummarized savedCategory = categoryMenuService.save(categoryMenuDto);

        HttpStatus status = (categoryMenuDto.getId() == null) ? HttpStatus.CREATED : HttpStatus.OK;

        return ResponseEntity.status(status).body(savedCategory);
    }

    @GetMapping
    public ResponseEntity<List<CategoryMenuSummarized>> findAll() {
        List<CategoryMenuSummarized> categories = categoryMenuService.findAll();
        return ResponseEntity.ok(categories);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        categoryMenuService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

