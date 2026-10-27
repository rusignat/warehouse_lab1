package warehouse.product.food;

import warehouse.Product;
import warehouse.core.Food;
import warehouse.valueProject.Price;
import warehouse.valueProject.Quantity;
import warehouse.valueProject.Weight;

public class Milk extends Food {
    public Milk(String name, Quantity quantity, Price price, Weight weight) {
        super(name, quantity, price, weight);
    }

    private Milk(Milk other) {
        super(other);
    }
    @Override
    public Product clone() {
        return new Milk(this);
    }
}
