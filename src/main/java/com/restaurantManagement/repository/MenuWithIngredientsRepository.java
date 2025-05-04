package com.restaurantManagement.repository;

import com.restaurantManagement.models.MenuWithIngredients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuWithIngredientsRepository extends JpaRepository<MenuWithIngredients, Long> {
}
