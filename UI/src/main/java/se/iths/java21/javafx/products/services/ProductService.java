package se.iths.java21.javafx.products.services;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import se.iths.java21.javafx.products.entities.Category;
import se.iths.java21.javafx.products.entities.Product;

import java.util.*;

public class ProductService implements Products {
    private final ObservableList<Product> products = FXCollections.observableArrayList();
    private final Map<Product, Integer> inventory = new HashMap<>();

    public ProductService() {
    }

    public void increaseInventory(Product product, int quantity) {
        int newTotal = inventory.getOrDefault(product, 0) + quantity;
        inventory.put(product, newTotal);
    }

    public void decreaseInventory(Product product, int quantity) {
        int newQuantity = inventory.getOrDefault(product, 0) - quantity;
        if (newQuantity >= 0)
            inventory.put(product, newQuantity);
        else
            throw new IllegalArgumentException("Finns ej tillräckligt med varor i inventory");
    }

    public int getInventory(Product product) {
        return inventory.getOrDefault(product, 0);
    }


    @Override
    public void addProducts(Collection<Product> products) {
        this.products.addAll(products);
    }

    @Override
    public void addProduct(Product product) {
        //Validating
        //Make copy if product isn't immutable
        if (!products.contains(product)) {
            products.add(product);
        }
    }

    @Override
    public void deleteProduct(Product product) {
        products.remove(product);
    }

    @Override
    public void deleteProduct(UUID uuid) {
        products.stream()
                .filter(product -> product.getId().equals(uuid))
                .findFirst()
                .ifPresent(products::remove);
    }

    @Override
    public ObservableList<Product> getProducts() {
        return products;
        //return List.copyOf(products);   //Returns unmodifiable List as a copy.
        //return Collections.unmodifiableList(products);  //Returns unmodifiable List with read through
    }


    @Override
    public Optional<Product> getProduct(UUID uuid) {
        return products.stream()
                .filter(product -> product.getId().equals(uuid))
                .findAny();
    }

    public List<Product> getByCategory(Category category) {
        return products.stream().
                filter(product -> product.getCategories().equals(category))
                .toList();
    }
}
