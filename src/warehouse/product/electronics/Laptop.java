package warehouse.product.electronics;

import warehouse.Product;
import warehouse.core.Electronics;
import warehouse.valueProject.Price;
import warehouse.valueProject.Quantity;
import warehouse.valueProject.Weight;

public class Laptop extends Electronics {
    public Laptop(String name, Quantity quantity, Price price, Weight weight) {
        super(name, quantity, price, weight);
    }
    private Laptop(Laptop other) {
        super(other);
    }
    @Override
    public Product clone() {
        return new Laptop(this);
    }
}
