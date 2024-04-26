package org.example;


import org.example.model.RecipeResponse;
import org.example.service.RecipeReaderService;
import org.example.service.SearchRecipeService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        RecipeReaderService recipeReaderService = new RecipeReaderService();
        RecipeResponse recipeResponse = recipeReaderService.readRecipeFile();

        Scanner scanner = new Scanner(System.in);

        System.out.println("\n please select the recipe type \n");
        System.out.println("starter");
        System.out.println("main course");
        System.out.println("dessert");

        String recipeType = scanner.nextLine();
        System.out.println("Enter a dish:");
        String dish = scanner.nextLine();
        scanner.close();

        SearchRecipeService searchRecipeService = new SearchRecipeService();
        searchRecipeService.searchRecipe(recipeType,dish,recipeResponse);


    }


}