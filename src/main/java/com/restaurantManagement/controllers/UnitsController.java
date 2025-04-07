package com.restaurantManagement.controllers;

import com.restaurantManagement.dto.UnitsDto;
import com.restaurantManagement.dto.UnitsSummarized;
import com.restaurantManagement.service.UnitService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/units")
@AllArgsConstructor
public class UnitsController {

    private UnitService unitService;

    @PostMapping
    public ResponseEntity<UnitsSummarized> createUnit(@Valid @RequestBody UnitsDto unitsDto) {
        UnitsSummarized savedUnit = unitService.save(unitsDto);

        return new ResponseEntity<>(savedUnit, HttpStatus.CREATED);
    }
}
