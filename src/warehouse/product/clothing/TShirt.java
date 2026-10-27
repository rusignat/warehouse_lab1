package warehouse.product.clothing;

import warehouse.Product;
import warehouse.core.Clothing;
import warehouse.valueProject.Price;
import warehouse.valueProject.Quantity;
import warehouse.valueProject.Weight;

public class TShirt extends Clothing {
    public TShirt(String name, Quantity quantity, Price price, Weight weight) {
        super(name, quantity, price, weight);
    }

    private TShirt(TShirt other) {
        super(other);
    }
    @Override
    public Product clone() {
        return new TShirt(this);
    }
}
