package com.example.recipe_api.repositories;

import com.example.recipe_api.models.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long>, JpaSpecificationExecutor<Recipe> {
    //derived queries
    List<Recipe> findByNameContainingIgnoreCase(String name);
    List<Recipe> findByCookingTimeInMinutesBetween(int start, int end);

}
