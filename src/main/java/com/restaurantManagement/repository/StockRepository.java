package com.restaurantManagement.repository;

import com.restaurantManagement.models.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock, Long> {
}
