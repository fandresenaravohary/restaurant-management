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
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int currentPrice;
    private String url;
    private String description;

    @ManyToOne
    @JoinColumn(name = "category_menu_id")
    private CategoryMenu categoryMenu;
    private Instant createdAt;
    private Instant updatedAt;

    @OneToMany(mappedBy = "menu")
    private List<MenuWithIngredients> menuWithIngredients = new ArrayList<>();
}
