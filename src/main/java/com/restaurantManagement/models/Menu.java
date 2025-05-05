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

    @Builder.Default
    @OneToMany(mappedBy = "menu")
    private List<MenuWithIngredients> menuWithIngredients = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "menu")
    private List<Order> orders = new ArrayList<>();

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


