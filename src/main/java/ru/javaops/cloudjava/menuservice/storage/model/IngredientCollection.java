package ru.javaops.cloudjava.menuservice.storage.model;

import lombok.Data;

import java.util.List;

@Data
public class IngredientCollection {
    private List<Ingredient> content;

    public IngredientCollection() {
    }
    public IngredientCollection(List<Ingredient> content) {
        this.content = content;
    }

}
