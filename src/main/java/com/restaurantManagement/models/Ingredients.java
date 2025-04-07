package com.restaurantManagement.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
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

    @Builder.Default
    @OneToMany(mappedBy = "ingredient")
    private List<MenuWithIngredients> menuWithIngredients = new ArrayList<>();

    @OneToOne(mappedBy = "ingredient")
    private Stock stock;

    @PrePersist
    public void onCreate() {
        this.createdAt = Instant.now();
        this.updatedAt = Instant.now();
    }

    @PreUpdate
    public void onUpdate() {
        this.updatedAt = Instant.now();
    }
}


