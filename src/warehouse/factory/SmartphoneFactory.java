package warehouse.factory;

import warehouse.Product;
import warehouse.product.electronics.Smartphone;
import warehouse.valueProject.Price;
import warehouse.valueProject.Quantity;
import warehouse.valueProject.Weight;

public class SmartphoneFactory extends ProductFactory {
    @Override
    public Product creatProduct(String name, int price, int quantity, double weight) {
        return new Smartphone(name, new Quantity(quantity), new Price(price), new Weight(weight));
    }
}
