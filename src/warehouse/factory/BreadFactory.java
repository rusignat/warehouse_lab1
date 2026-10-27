package warehouse.factory;

import warehouse.Product;
import warehouse.product.food.Bread;
import warehouse.valueProject.Price;
import warehouse.valueProject.Quantity;
import warehouse.valueProject.Weight;

public class BreadFactory extends ProductFactory {
    @Override
    public Product creatProduct(String name, int price, int quantity, double weight) {
        return new Bread(name, new Quantity(quantity), new Price(price), new Weight(weight));
    }
}