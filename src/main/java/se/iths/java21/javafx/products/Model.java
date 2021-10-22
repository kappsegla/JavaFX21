package se.iths.java21.javafx.products;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.paint.Color;
import se.iths.java21.javafx.products.entities.Product;
import se.iths.java21.javafx.products.services.ProductService;

public class Model {
    ProductService productService = new ProductService();

    ObservableList<Product> observableList;

    IntegerProperty selectedIndex = new SimpleIntegerProperty();

    ObjectProperty<Product> product = new SimpleObjectProperty<>();

    public Model() {
        observableList = FXCollections.observableList(productService.getProducts());
    }


}
