package org.example.recipe;

import org.example.constants.RecipeConstants;

public class MainCourse extends Recipe{

    public String getType() {
        return type;
    }

    private final String type = RecipeConstants.MAIN_COURSE_TYPE;

    public MainCourse(String title,
                      String ingredients,
                      String description,
                      String duration,
                      String portions,
                      String country) {
        super(title, ingredients, description, duration, portions, country);
    }
}
