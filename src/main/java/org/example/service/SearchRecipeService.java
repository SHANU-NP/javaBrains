package org.example.service;

import org.example.constants.RecipeConstants;
import org.example.model.RecipeResponse;
import org.example.recipe.Recipe;

import java.util.List;

public class SearchRecipeService {

    public void searchRecipe(String recipeType , String dish, RecipeResponse recipeResponse){

        switch (recipeType){
            case RecipeConstants.STARTER_TYPE -> printRecipesByType(recipeType,dish,recipeResponse.getStarters());
            case RecipeConstants.MAIN_COURSE_TYPE -> printRecipesByType(recipeType,dish,recipeResponse.getMainCourses());
            case RecipeConstants.DESSERT_TYPE -> printRecipesByType(recipeType,dish,recipeResponse.getDesserts());
            default -> System.out.println("Unfortunately no recipe found");
        }

    }

    public void printRecipesByType(String recipeType, String dish, List<? extends Recipe> recipes) {
        recipes.stream()
                .filter(recipe -> recipe.getTitle().equals(dish))
                .forEach(recipeData -> {
                    System.out.println("Recipe type : "+recipeType+" Title : "
                            +recipeData.getTitle()+"  Description: "
                            +recipeData.getDescription()+"  Duration: "
                            +recipeData.getDuration()+" Country : "
                            +recipeData.getCountry()+" ingredients: "+
                            recipeData.getIngredients());
                });

        if (recipes.stream().noneMatch(recipe -> recipe.getTitle().equals(dish))) {
            System.out.println("Unfortunately no recipe found");
        }
    }

}
