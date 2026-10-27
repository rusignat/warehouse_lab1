package warehouse.core;

import warehouse.Product;
import warehouse.valueProject.Price;
import warehouse.valueProject.Quantity;
import warehouse.valueProject.Weight;

public abstract class Food extends Product {

    public Food(String name, Quantity quantity, Price price, Weight weight) {
        super(name, "Food", quantity, price, weight);
    }

    protected Food (Food other) {
        super(other);
    }
}
