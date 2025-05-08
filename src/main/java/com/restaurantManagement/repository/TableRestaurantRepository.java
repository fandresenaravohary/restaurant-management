package com.restaurantManagement.repository;

import com.restaurantManagement.models.TableRestaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TableRestaurantRepository extends JpaRepository<TableRestaurant, Long> {
}
