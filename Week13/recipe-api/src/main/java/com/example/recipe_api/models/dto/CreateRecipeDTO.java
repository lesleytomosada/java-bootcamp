package com.example.recipe_api.models.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateRecipeDTO {
    @NotBlank(message = "Name is mandatory")
    @Size(max = 200)
    private String name;

    @NotBlank(message = "Instructions are mandatory")
    private String instructions;

    @Min(value = 1, message = "Cooking time should be at least 1 minute")
    private int cookingTimeInMinutes;
    private boolean isVegan;
    private boolean isNutFree;
    private boolean isGlutenFree;
}
