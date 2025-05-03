package com.restaurantManagement.controllers;

import com.restaurantManagement.dto.IngredientsDto;
import com.restaurantManagement.summarized.IngredientsSummarized;
import com.restaurantManagement.service.IngredientsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ingredients")
@RequiredArgsConstructor
public class IngredientsController {

    private final IngredientsService ingredientsService;

    @PostMapping
    public ResponseEntity<IngredientsSummarized> createOrUpdateIngredients(@Valid @RequestBody IngredientsDto ingredientsDto) {
        IngredientsSummarized savedIngredient = ingredientsService.save(ingredientsDto);

        HttpStatus status = (ingredientsDto.getId() == null) ? HttpStatus.CREATED : HttpStatus.OK;

        return ResponseEntity.status(status).body(savedIngredient);
    }

    @GetMapping
    public ResponseEntity<List<IngredientsSummarized>> findAllIngredients() {
        List<IngredientsSummarized> ingredients = ingredientsService.findAll();
        return ResponseEntity.ok(ingredients);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteIngredient(@PathVariable Long id) {
        ingredientsService.delete(id);
        return ResponseEntity.noContent().build();
    }
}