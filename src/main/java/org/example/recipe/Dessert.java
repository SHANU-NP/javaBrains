package org.example.recipe;

import org.example.constants.RecipeConstants;

public class Dessert extends Recipe{

    private final String type = RecipeConstants.DESSERT_TYPE;

    public String getType() {
        return type;
    }

    public Dessert(String title,
                   String ingredients,
                   String description,
                   String duration,
                   String portions,
                   String country) {
        super(title, ingredients, description, duration, portions, country);
    }
}
