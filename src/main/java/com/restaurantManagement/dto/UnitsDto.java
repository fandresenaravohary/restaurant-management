package com.restaurantManagement.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UnitsDto {
    private Long id;

    @NotNull(message = "Le nom de l'unité ne peut pas être nul")
    @Size(min = 1, max = 10, message = "Le nom de l'unité doit être entre 1 et 10 caractères")
    private String name;

    @NotNull(message = "L'abréviation de l'unité ne peut pas être nulle")
    @Size(min = 1, max = 10, message = "L'abréviation de l'unité doit être entre 1 et 10 caractères")
    private String abbreviation;
}

