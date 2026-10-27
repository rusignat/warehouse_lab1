package test;

import org.junit.jupiter.api.Test;
import warehouse.valueProject.Quantity;

import static org.junit.jupiter.api.Assertions.assertThrows;

class QuantityTest {
    @Test
    void validationOnNegativeQuantity() {
        assertThrows(IllegalArgumentException.class, () -> new Quantity(-1));
    }

    @Test
    void validationSetterOnNegativeQuantity() {
        Quantity quantity = new Quantity(5);
        assertThrows(IllegalArgumentException.class, () -> quantity.setValue(-2));
    }

    @Test
    void validationOnNegativeChangeQuantity() {
        int delta = -10;
        Quantity quantity = new Quantity(5);
        assertThrows(IllegalArgumentException.class, () -> quantity.changeQuantity(delta));
    }
}
