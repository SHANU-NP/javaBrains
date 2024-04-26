package org.example.recipe;

public abstract class Recipe {

    private String title;
    private String ingredients;
    private String description;
    private String duration;
    private String portions;
    private String country;

    public Recipe() {}

    public Recipe(String title,
                  String ingredients,
                  String description,
                  String duration,
                  String portions,
                  String country) {
        this.title = title;
        this.ingredients = ingredients;
        this.description = description;
        this.duration = duration;
        this.portions = portions;
        this.country = country;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getPortions() {
        return portions;
    }

    public void setPortions(String portions) {
        this.portions = portions;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
