package warehouse.product.clothing;

import warehouse.Product;
import warehouse.core.Clothing;
import warehouse.valueProject.Price;
import warehouse.valueProject.Quantity;
import warehouse.valueProject.Weight;

public class Jacket extends Clothing {
    public Jacket(String name, Quantity quantity, Price price, Weight weight) {
        super(name, quantity, price, weight);
    }

    private Jacket(Jacket other) {
        super(other);
    }
    @Override
    public Product clone() {
        return new Jacket(this);
    }
}

