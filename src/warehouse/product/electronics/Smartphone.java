package warehouse.product.electronics;

import warehouse.core.Electronics;
import warehouse.Product;
import warehouse.valueProject.Price;
import warehouse.valueProject.Quantity;
import warehouse.valueProject.Weight;

public class Smartphone extends Electronics {
    public Smartphone(String name, Quantity quantity, Price price, Weight weight) {
        super(name, quantity, price, weight);
    }

    private Smartphone(Smartphone other) {
        super(other);
    }
    @Override
    public Product clone() {
        return new Smartphone(this);
    }
}

