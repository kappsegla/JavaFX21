package se.iths.java21.javafx.products;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import se.iths.java21.javafx.products.entities.Product;
import se.iths.java21.javafx.products.services.ProductService;
import se.iths.java21.javafx.products.services.Products;

public class Model {
    Products products;

    ObservableList<Product> observableList;

    public Model(Products products) {
        this.products = products;
        observableList = FXCollections.observableList(products.getProducts());
    }


}
