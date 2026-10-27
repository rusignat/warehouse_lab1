package test;

import org.junit.jupiter.api.Test;
import warehouse.Product;
import warehouse.factory.SmartphoneFactory;

import static org.junit.jupiter.api.Assertions.*;

class SmartphoneFactoryTest {

    @Test
    void createSmartphoneWithCorrect() {
        SmartphoneFactory factory = new SmartphoneFactory();
        Product product = factory.creatProduct("iphone", 1000, 5, 150);

        assertNotNull(product);
        assertEquals("iphone", product.getName());
        assertEquals("Electronics", product.getCategory());
        assertEquals(1000, product.getPrice().getValue());
        assertEquals(5, product.getQuantity().getValue());
        assertEquals(150, product.getWeight().getValue());
    }
}
