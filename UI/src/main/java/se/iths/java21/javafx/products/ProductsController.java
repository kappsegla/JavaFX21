package se.iths.java21.javafx.products;

import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import se.iths.java21.javafx.products.entities.Brand;
import se.iths.java21.javafx.products.entities.Category;
import se.iths.java21.javafx.products.entities.Product;
import se.iths.java21.javafx.products.services.ProductService;

import java.io.File;
import java.math.BigDecimal;
import java.util.UUID;


public class ProductsController {

    public TextField uuid;
    public TextField productName;
    public Spinner<Integer> priceSpinner;
    public TextField categoryName;
    public TextField brandName;
    public ListView<Product> listView;
    public Button addButton;

    Stage mainStage;

    Model model;

    public void initialize() {
        model = new Model(new ProductService());
        model.products.addProduct(new Product(UUID.randomUUID(), "Name1", BigDecimal.ONE, Category.of("Category 1"), Brand.of("Brand")));
        model.products.addProduct(new Product(UUID.randomUUID(), "Name2", BigDecimal.ONE, Category.of("Category 1"), Brand.of("Brand")));
        model.products.addProduct(new Product(UUID.randomUUID(), "Name3", BigDecimal.ONE, Category.of("Category 1"), Brand.of("Brand")));
        listView.setItems(model.observableList);
        model.selectedProduct.bind(listView.getSelectionModel().selectedItemProperty());

        productName.textProperty().bindBidirectional(model.productName);
        categoryName.textProperty().bindBidirectional(model.categoryName);
        brandName.textProperty().bindBidirectional(model.brandName);
        model.price.bindBidirectional(priceSpinner.getValueFactory().valueProperty());

        addButton.disableProperty().bind(model.validProduct);
    }

    public ProductsController() {
    }

    public ProductsController(Model model) {
        this.model = model;
    }

    public void onDelete(ActionEvent actionEvent) {
        model.deleteSelectedProduct();
    }

    public void onAdd(ActionEvent actionEvent) {
        model.addNewProduct();
    }

    public void onSave(ActionEvent actionEvent) {
    }
}
