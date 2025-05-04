package com.restaurantManagement.repository;

import com.restaurantManagement.models.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StockRepository extends JpaRepository<Stock, Long> {

    Optional<Stock> findByIngredientId(Long ingredientId);

}
