package com.restaurantManagement.repository;

import com.restaurantManagement.models.CategoryMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryMenuRepository extends JpaRepository<CategoryMenu, Long> {
}
