package warehouse.factory;

import warehouse.Product;

public abstract class ProductFactory {
    public abstract Product creatProduct(String name, int price, int quantity, double weight);
}
