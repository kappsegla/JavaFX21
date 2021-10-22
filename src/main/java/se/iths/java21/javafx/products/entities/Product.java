package se.iths.java21.javafx.products.entities;


import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

public class Product {
    private final UUID id;
    private final String name;
    private final BigDecimal price;
    private final Category category;
    private final Brand brand;

    public Product(UUID id, String name, BigDecimal price, Category categories, Brand brand) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = categories;
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public UUID getId() {
        return id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Category getCategories() {
        return category;
    }

    public Brand getBrand() {
        return brand;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id) && Objects.equals(name, product.name) && Objects.equals(price, product.price) && Objects.equals(category, product.category) && Objects.equals(brand, product.brand);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, category, brand);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", categories=" + category +
                ", brand=" + brand +
                '}';
    }
}
