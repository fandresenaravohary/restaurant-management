package com.restaurantManagement.repository;

import com.restaurantManagement.models.CategoryMenu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryMenuRepository extends JpaRepository<CategoryMenu, Long> {
}
