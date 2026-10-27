package warehouse.factory;

import warehouse.Product;
import warehouse.product.electronics.Laptop;
import warehouse.valueProject.Price;
import warehouse.valueProject.Quantity;
import warehouse.valueProject.Weight;

public class LaptopFactory extends ProductFactory {
    @Override
    public Product creatProduct(String name, int price, int quantity, double weight) {
        return new Laptop(name, new Quantity(quantity), new Price(price), new Weight(weight));
    }
}
