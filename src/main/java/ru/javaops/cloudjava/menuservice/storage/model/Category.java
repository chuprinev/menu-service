package ru.javaops.cloudjava.menuservice.storage.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import org.springframework.lang.Nullable;

public enum Category {
    BREAKFAST,
    LUNCH,
    DINNER,
    DRINKS,
    SNACKS,
    SALADS;

    @Nullable
    @JsonCreator
    public static Category fromString(String name) {
        for (Category category : Category.values()) {
            if (category.name().equalsIgnoreCase(name)) {
                return category;
            }
        }
        return null;
    }
}
