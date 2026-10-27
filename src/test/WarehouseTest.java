package test;

import warehouse.Product;
import warehouse.Warehouse;
import warehouse.factory.SmartphoneFactory;
import warehouse.valueProject.Price;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WarehouseTest {

    private static Product phone(String name, int price, int quantity, int weight) {
        return new SmartphoneFactory().creatProduct(name, price, quantity, weight);
    }

    private static int count(Warehouse warehouse) {
        int n = 0;
        for (Product ignored : warehouse) {
            n++;
        }
        return n;
    }

    @Test
    void copyFromOriginal() {
        Warehouse original = new Warehouse(10);
        Product phone = phone("iphone", 1000, 5, 200);
        original.addProduct(phone);

        Warehouse copy = new Warehouse(original);
        Product copied = copy.findById(phone.getId());

        assertNotNull(copied);
        assertNotSame(phone, copied);

        copied.changeQuantity(-2);
        copied.setPrice(new Price(1500));

        assertEquals(3, copied.getQuantity().getValue());
        assertEquals(1500, copied.getPrice().getValue());
        assertEquals(5, phone.getQuantity().getValue());
        assertEquals(1000, phone.getPrice().getValue());
    }

    @Test
    void transferFromObject() {
        Warehouse warehouseA = new Warehouse(250);
        Warehouse warehouseB = new Warehouse(150);
        Product product = phone("iphone", 1000, 10, 200);
        warehouseA.addProduct(product);

        warehouseB.transferFrom(warehouseA);

        assertSame(product, warehouseB.findById(product.getId()));
        assertEquals(0, count(warehouseA));
        assertEquals(1, count(warehouseB));
    }
}