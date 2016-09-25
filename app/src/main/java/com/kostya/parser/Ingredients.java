package com.kostya.parser;

/**
 * Created by Степучева Наталья on 25.09.2016.
 */

public class Ingredients {
    private String ingredient;
    private String weight;

    public Ingredients(String ingredient, String weight) {
        this.ingredient = ingredient;
        this.weight = weight;
    }

    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }
}
