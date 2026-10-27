package warehouse.core;

import warehouse.Product;
import warehouse.valueProject.Price;
import warehouse.valueProject.Quantity;
import warehouse.valueProject.Weight;

public abstract class Electronics extends Product {

    public Electronics(String name, Quantity quantity, Price price, Weight weight) {
        super(name, "Electronics", quantity, price, weight);
    }

    protected Electronics(Electronics other) {
        super(other);
    }
}
