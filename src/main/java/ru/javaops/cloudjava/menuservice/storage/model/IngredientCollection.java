package ru.javaops.cloudjava.menuservice.storage.model;

import lombok.Data;

import java.util.List;

@Data
public class IngredientCollection {
    private List<Ingredient> ingredients;

    public IngredientCollection() {
    }
    public IngredientCollection(List<Ingredient> content) {
        this.ingredients = content;
    }

}
