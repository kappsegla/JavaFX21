package se.iths.java21.javafx;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HelloControllerTest {

    HelloController helloController = new HelloController(new Model());

    @Test
    void test() {
        helloController.onHelloButtonClick();
        assertEquals("Button pressed",helloController.model.getText());
    }

}