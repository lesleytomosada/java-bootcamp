package com.example.recipe_api.models.specifications;

import com.example.recipe_api.models.Recipe;
import org.springframework.data.jpa.domain.Specification;

public class RecipeSpecification {
    //output of one function is input of next
    public static Specification<Recipe> instructionsContains(String instructions){
        return (root, query, criteriaBuilder) -> {
            //did they actually want to filter by instructions
            if(instructions == null || instructions.isEmpty()){
                //dont alter query, leave as is
                return criteriaBuilder.conjunction();
            }
            return criteriaBuilder.like(root.get("instructions"), "%"+ instructions + "%");
        };
    }

    public static Specification<Recipe> nameContains(String name){
        return (root, query, criteriaBuilder) -> {
            if (name == null || name.isEmpty()){
                return criteriaBuilder.conjunction();
            }
            return criteriaBuilder.like(root.get("name"), "%" + name + "%");
        };
    }

    public static Specification<Recipe> cookingTimeBetween(Integer start, Integer end){
        return (root, query, criteriaBuilder) -> {
            if (start == null && end == null){
                return criteriaBuilder.conjunction();
            }
            if (start == null){
                return criteriaBuilder.lessThanOrEqualTo(root.get("cookingTimeInMinutes"), end);
            }
            if (end == null){
                return criteriaBuilder.greaterThanOrEqualTo(root.get("cookingTimeInMinutes"), start);
            }
            return criteriaBuilder.between(root.get("cookingTimeInMinutes"), start,end);
        };
    }

    public static Specification<Recipe> isVegan(Boolean isVegan){
        return (root, query, criteriaBuilder) -> {
            if(isVegan == null){
                return criteriaBuilder.conjunction();
            }
            return criteriaBuilder.equal(root.get("isVegan"), isVegan);
        };
    }
}
