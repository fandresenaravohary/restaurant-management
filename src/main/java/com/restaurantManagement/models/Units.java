package com.restaurantManagement.models;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Units {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String abbreviation;
    private Instant createdAt;
    private Instant updatedAt;

    @OneToMany(mappedBy = "units")
    private List<Ingredients> ingredients = new ArrayList<>();
}
