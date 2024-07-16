package com.example.recipe_api.services;

import com.example.recipe_api.exceptions.ResourceNotFoundException;
import com.example.recipe_api.mapper.RecipeMapper;
import com.example.recipe_api.models.Recipe;
import com.example.recipe_api.models.dto.CreateRecipeDTO;
import com.example.recipe_api.models.dto.RecipeDTO;
import com.example.recipe_api.models.dto.UpdateRecipeDTO;
import com.example.recipe_api.models.queryparams.RecipeSearchParams;
import com.example.recipe_api.models.specifications.RecipeSpecification;
import com.example.recipe_api.repositories.RecipeRepository;
import io.swagger.v3.core.filter.SpecFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecipeService {
    private RecipeRepository recipeRepository;

    @Autowired
    private RecipeMapper recipeMapper;

    @Autowired
    public RecipeService(RecipeRepository recipeRepository){
        this.recipeRepository = recipeRepository;
    }

    public List<RecipeDTO> getAllRecipes(){
        List<Recipe> recipes = this.recipeRepository.findAll();
        return recipes.stream().map(recipeMapper::toRecipeDTO).toList();
    }

    public RecipeDTO getRecipeById(Long id){
        var recipe = this.recipeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Recipe not " +
                "found with id: " + id));
                return recipeMapper.toRecipeDTO(recipe);
    }

    public void deleteRecipe(Long id){
        // check to see if the recipe they want actually exists
        // if it doesn't it'll throw and exception
        Recipe recipe = recipeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Recipe not found with id: " + id));

    }

    public RecipeDTO createRecipe(CreateRecipeDTO dto){
        Recipe recipe = recipeMapper.fromRecipeDTOtoRecipe(dto);
        Recipe createdRecipe = recipeRepository.save(recipe);
        return recipeMapper.toRecipeDTO(createdRecipe);
    }

    public RecipeDTO updateRecipe(UpdateRecipeDTO dto, Long id){
        Recipe recipe = recipeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Recipe not found with id: " + id));
        recipe.setName(dto.getName());
        recipe.setInstructions(dto.getInstructions());
        recipe.setCookingTimeInMinutes(dto.getCookingTimeInMinutes());
        recipe.setVegan(dto.isVegan());
        recipe.setNutFree(dto.isNutFree());
        recipe.setGlutenFree(dto.isGlutenFree());

        Recipe updatedRecipe = recipeRepository.save(recipe);

        return recipeMapper.toRecipeDTO(updatedRecipe);
    }

    public List<RecipeDTO> getRecipesByName(String name){
        List<Recipe> recipes = recipeRepository.findByNameContainingIgnoreCase(name);
        return recipes.stream().map(recipeMapper::toRecipeDTO).toList();
    }

    public List<RecipeDTO> filterRecipes(RecipeSearchParams searchParams) {
        //build your specification
        Specification<Recipe> spec =
                Specification.where(RecipeSpecification.instructionsContains(searchParams.getInstructions()))
                        .and(RecipeSpecification.nameContains(searchParams.getName()))
                        .and(RecipeSpecification.cookingTimeBetween(searchParams.getMinCookingTime(),
                                searchParams.getMaxCookingTime()))
                        .and(RecipeSpecification.isVegan(searchParams.getVegan()));

        List<Recipe> filteredRecipes = recipeRepository.findAll(spec);
        return filteredRecipes.stream().map(recipeMapper::toRecipeDTO).toList();
    }
}
