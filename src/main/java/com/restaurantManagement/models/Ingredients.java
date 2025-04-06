package com.restaurantManagement.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Ingredients {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String url;

    @ManyToOne
    @JoinColumn(name = "units_id")
    private Units units;

    @ManyToOne
    @JoinColumn(name = "category_ingredients_id")
    private CategoryIngredients categoryIngredients;
    private Instant createdAt;
    private Instant updatedAt;

    @OneToMany(mappedBy = "ingredient")
    private List<MenuWithIngredients> menuWithIngredients = new ArrayList<>();

    @OneToOne(mappedBy = "ingredient")
    private Stock stock;
}
