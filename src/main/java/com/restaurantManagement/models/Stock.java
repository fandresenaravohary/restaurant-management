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
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "ingredient_id", unique = true)
    private Ingredients ingredient;
    private Double quantity;
    private Instant createdAt;
    private Instant updatedAt;

    @OneToMany(mappedBy = "stock")
    private List<StockHistory> stockHistories = new ArrayList<>();
}
