package com.example.recipe_api.mapper;

import com.example.recipe_api.models.Recipe;
import com.example.recipe_api.models.dto.CreateRecipeDTO;
import com.example.recipe_api.models.dto.RecipeDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface RecipeMapper {
    RecipeMapper INSTANCE = Mappers.getMapper(RecipeMapper.class);
    RecipeDTO toRecipeDTO(Recipe recipe);
    Recipe toRecipe(RecipeDTO recipeDTO);
    Recipe fromRecipeDTOtoRecipe(CreateRecipeDTO createRecipeDTO);
}
