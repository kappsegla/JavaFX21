package se.iths.java21.javafx.products.entities;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Brand {
    private static final Set<Brand> brands = new HashSet<>();
    private final String name;

    private Brand(String name) {
        this.name = name;
        brands.add(this);
    }

    public static Brand of(String name) {
        return brands.stream()
                .filter(b -> b.name.equals(name))
                .findFirst()
                .orElse(new Brand(name));
    }

    public String name() {
        return this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Brand brand = (Brand) o;
        return Objects.equals(name, brand.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Brand{" +
                "name='" + name + '\'' +
                '}';
    }
}
