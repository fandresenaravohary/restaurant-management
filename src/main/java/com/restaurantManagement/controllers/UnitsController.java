package com.restaurantManagement.controllers;

import com.restaurantManagement.dto.UnitsDto;
import com.restaurantManagement.dto.UnitsSummarized;
import com.restaurantManagement.service.UnitService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/units")
@RequiredArgsConstructor
public class UnitsController {

    private final UnitService unitService;

    @PostMapping
    public ResponseEntity<UnitsSummarized> createUnit(@Valid @RequestBody UnitsDto unitsDto) {
        UnitsSummarized savedUnit = unitService.save(unitsDto);
        return new ResponseEntity<>(savedUnit, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<UnitsSummarized>> getAllUnits() {
        List<UnitsSummarized> units = unitService.findAll();
        return ResponseEntity.ok(units);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUnit(@PathVariable Long id) {
        unitService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

