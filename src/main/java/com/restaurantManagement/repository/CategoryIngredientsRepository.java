package com.restaurantManagement.repository;

import com.restaurantManagement.models.CategoryIngredients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryIngredientsRepository extends JpaRepository<CategoryIngredients, Long> {
}
