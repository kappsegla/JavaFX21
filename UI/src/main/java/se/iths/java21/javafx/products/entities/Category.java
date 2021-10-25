package se.iths.java21.javafx.products.entities;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Category {
    private final String name;
    private static final Set<Category> categories = new HashSet<>();

    private Category(String name) {
        this.name = name;
        categories.add(this);
    }

    public String name() {
        return name;
    }

    public static Category of(String name) {
        return categories.stream()
                .filter(c -> c.name().equals(name))
                .findAny()
                .orElse(new Category(name));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(name, category.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Category{" +
                "name='" + name + '\'' +
                '}';
    }
}
