package com.restaurantManagement.repository;

import com.restaurantManagement.summarized.IngredientsSummarized;
import com.restaurantManagement.models.Ingredients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IngredientsRepository extends JpaRepository<Ingredients, Long> {

    @Query("""
        SELECT new com.restaurantManagement.summarized.IngredientsSummarized(
            i.id,
            i.name,
            i.url,
            u.name,
            c.name,
            s.id,
            s.quantity,
            i.createdAt,
            i.updatedAt
        )
        FROM Ingredients i
        LEFT JOIN i.units u
        LEFT JOIN i.categoryIngredients c
        LEFT JOIN i.stock s
        """)
    List<IngredientsSummarized> findAllIngredientsSummarized();
}
