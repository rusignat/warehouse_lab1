package warehouse.core;

import warehouse.Product;
import warehouse.valueProject.Price;
import warehouse.valueProject.Quantity;
import warehouse.valueProject.Weight;

public abstract class Clothing extends Product {

    public Clothing(String name, Quantity quantity, Price price, Weight weight) {
        super(name, "Clothing", quantity, price, weight);
    }

    protected Clothing(Clothing other) {
        super(other);
    }

}
