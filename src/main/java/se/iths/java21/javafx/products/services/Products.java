package se.iths.java21.javafx.products.services;

import se.iths.java21.javafx.products.entities.Product;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface Products {
    void addProducts(Collection<Product> products);

    void addProduct(Product product);

    void deleteProduct(Product product);

    void deleteProduct(UUID uuid);

    List<Product> getProducts();

    Optional<Product> getProduct(UUID uuid);
}
