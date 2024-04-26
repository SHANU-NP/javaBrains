package org.example.service;

import org.example.constants.RecipeConstants;
import org.example.model.RecipeResponse;
import org.example.recipe.Dessert;
import org.example.recipe.MainCourse;
import org.example.recipe.Recipe;
import org.example.recipe.Starter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.example.constants.RecipeConstants.RECIPE_READER_PATH;
import static org.example.constants.RecipeConstants.SUCCESSFULLY_ADDED;

public class RecipeReaderService {

    public RecipeResponse readRecipeFile(){

        List<Starter> starters = new ArrayList<>();
        List<MainCourse> mainCourses = new ArrayList<>();
        List<Dessert> desserts = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(RECIPE_READER_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");

                Recipe recipe = null;
                switch (values[0]){
                    case RecipeConstants.STARTER_TYPE -> {
                        recipe = new Starter(values[1], values[2],values[3],values[4],values[5],values[6]);
                        starters.add((Starter) recipe);
                        System.out.println(RecipeConstants.STARTER_TYPE + recipe.getTitle() + SUCCESSFULLY_ADDED);
                    }
                    case RecipeConstants.MAIN_COURSE_TYPE -> {
                        recipe = new MainCourse(values[1], values[2],values[3],values[4],values[5],values[6]);
                        mainCourses.add((MainCourse) recipe);
                        System.out.println(RecipeConstants.MAIN_COURSE_TYPE + recipe.getTitle() + SUCCESSFULLY_ADDED);
                    }
                    case RecipeConstants.DESSERT_TYPE-> {
                        recipe = new Dessert(values[1], values[2],values[3],values[4],values[5],values[6]);
                        desserts.add((Dessert) recipe);
                        System.out.println(RecipeConstants.DESSERT_TYPE + recipe.getTitle() + SUCCESSFULLY_ADDED);
                    }
                    default -> {}

                }

            }

        } catch (IOException e) {
            System.out.println("Exception occurred while reading recipe book CSV file , message : " + e.getLocalizedMessage());
        }
        return new RecipeResponse(starters,mainCourses,desserts);
    }





}
