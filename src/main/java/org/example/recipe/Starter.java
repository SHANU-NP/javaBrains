package org.example.recipe;

import org.example.constants.RecipeConstants;

public class Starter extends Recipe{

    private final String type = RecipeConstants.STARTER_TYPE;

    public Starter(String title,
                   String ingredients,
                   String description,
                   String duration,
                   String portions,
                   String country) {
        super(title, ingredients, description, duration, portions, country);
    }

    public String getType() {
        return type;
    }
}
