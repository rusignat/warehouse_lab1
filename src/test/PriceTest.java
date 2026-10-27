package test;

import org.junit.jupiter.api.Test;
import warehouse.valueProject.Price;

import static org.junit.jupiter.api.Assertions.*;

class PriceTest {

    @Test
    void validationOnNegativePrice() {
        assertThrows(IllegalArgumentException.class, () -> new Price(-1));
    }

    @Test
    void validationSetterOnNegativePrice() {
        Price price = new Price(5);
        assertThrows(IllegalArgumentException.class, () -> price.setValue(-2));
    }
}
