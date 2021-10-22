package se.iths.java21.javafx.products;

import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import se.iths.java21.javafx.products.entities.Brand;
import se.iths.java21.javafx.products.entities.Category;
import se.iths.java21.javafx.products.entities.Product;

import java.math.BigDecimal;
import java.util.UUID;


public class ProductsController {

    @FXML
    ListView<Product> listView;

    @FXML
    TextField productName;

    Model model;

    public ProductsController() {
        model = new Model();
//        model.productService.addProduct(new Product(UUID.randomUUID(),"Name1", BigDecimal.ONE,Category.of("Category 1"), Brand.of("Brand")));
//        model.productService.addProduct(new Product(UUID.randomUUID(),"Name2", BigDecimal.ONE,Category.of("Category 1"), Brand.of("Brand")));
//        model.productService.addProduct(new Product(UUID.randomUUID(),"Name3", BigDecimal.ONE,Category.of("Category 1"), Brand.of("Brand")));
    }

    public ProductsController(Model model) {
        this.model = model;
    }

//    private void changed(ObservableValue<? extends Product> observableValue, Product oldValue, Product newValue) {
//        if( newValue != null)
//        {
//            productName.textProperty().bind(observableValue.getValue().nameProperty());
//        }
//    }

    public void initialize() {
//        listView.setItems(model.observableList);
//        model.product.bind(listView.getSelectionModel().selectedItemProperty());
//        model.product.addListener(this::changed);
    }

}
