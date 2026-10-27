package test;

import org.junit.jupiter.api.Test;
import warehouse.valueProject.Weight;

import static org.junit.jupiter.api.Assertions.assertThrows;

class WeightTest {

    @Test
    void validationOnNegativeWeight() {
        assertThrows(IllegalArgumentException.class, () -> new Weight(-1));
    }

    @Test
    void validationSetterOnNegativeWeight() {
        Weight weight = new Weight(5);
        assertThrows(IllegalArgumentException.class, () -> weight.setValue(-2));
    }
}
