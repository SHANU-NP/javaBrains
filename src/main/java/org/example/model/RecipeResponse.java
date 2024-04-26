package org.example.model;

import org.example.recipe.Dessert;
import org.example.recipe.MainCourse;
import org.example.recipe.Starter;

import java.util.ArrayList;
import java.util.List;

public class RecipeResponse {
    private List<Starter> starters;
    private List<MainCourse> mainCourses;
    private List<Dessert> desserts;

    public RecipeResponse(List<Starter> starters, List<MainCourse> mainCourses, List<Dessert> desserts) {
        this.starters = starters;
        this.mainCourses = mainCourses;
        this.desserts = desserts;
    }

    public RecipeResponse() {}

    public List<Starter> getStarters() {
        return starters;
    }

    public void setStarters(List<Starter> starters) {
        this.starters = starters;
    }

    public List<MainCourse> getMainCourses() {
        return mainCourses;
    }

    public void setMainCourses(List<MainCourse> mainCourses) {
        this.mainCourses = mainCourses;
    }

    public List<Dessert> getDesserts() {
        return desserts;
    }

    public void setDesserts(List<Dessert> desserts) {
        this.desserts = desserts;
    }
}
