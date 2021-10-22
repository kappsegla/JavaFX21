package se.iths.java21.javafx.products;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import se.iths.java21.javafx.products.entities.Brand;
import se.iths.java21.javafx.products.entities.Category;
import se.iths.java21.javafx.products.entities.Product;
import se.iths.java21.javafx.products.services.ProductService;
import se.iths.java21.javafx.products.services.Products;

import java.math.BigDecimal;
import java.util.UUID;

public class Model {
    Products products;

    ObservableList<Product> observableList;
    ObjectProperty<Product> selectedProduct = new SimpleObjectProperty<>();
    StringProperty productName = new SimpleStringProperty();
    ObjectProperty<Integer> price = new SimpleObjectProperty<>(1);
    StringProperty categoryName = new SimpleStringProperty();
    StringProperty brandName = new SimpleStringProperty();

    BooleanBinding validProduct = Bindings.isEmpty(this.productName)
            .or(Bindings.isEmpty(this.categoryName))
            .or(Bindings.isEmpty(this.brandName))
            .or(Bindings.createBooleanBinding(() -> this.price.getValue() < 5, this.price));


    public Model(Products products) {
        this.products = products;
        observableList = products.getProducts();
    }

    public void deleteSelectedProduct() {
        products.deleteProduct(selectedProduct.getValue());
    }

    public void addNewProduct() {
        var product = new Product(UUID.randomUUID(),
                productName.getValue(),
                BigDecimal.valueOf(price.getValue().doubleValue()),
                Category.of(categoryName.getValue()),
                Brand.of(brandName.getValue()));
        products.addProduct(product);
    }
}
