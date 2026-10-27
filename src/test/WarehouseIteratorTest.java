package test;


import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;
import warehouse.Product;
import warehouse.Warehouse;
import warehouse.factory.JacketFactory;

import static org.junit.jupiter.api.Assertions.*;

class WarehouseIteratorTest {

    private static Product jacket (String name) {
        return new JacketFactory().creatProduct(name, 5, 5, 300);
    }

    @Test
    void runAllProductsInWarehouse() {
        Warehouse warehouse = new Warehouse(10);
        Product jacket1 = jacket("jacket1");
        Product jacket2 = jacket("jacket2");
        Product jacket3 = jacket("jacket3");

        warehouse.addProduct(jacket1);
        warehouse.addProduct(jacket2);
        warehouse.addProduct(jacket3);

        Iterator<Product> warehouseI = warehouse.iterator();

        assertSame(warehouseI.next(), jacket1);
        assertSame(warehouseI.next(), jacket2);
        assertSame(warehouseI.next(), jacket3);
        assertFalse(warehouseI.hasNext());
    }

    @Test
    void nextAfterEnd() {
        Warehouse warehouse = new Warehouse(10);
        warehouse.addProduct(jacket("jacket1"));

        Iterator<Product> it = warehouse.iterator();
        it.next();

        assertThrows(NoSuchElementException.class, it::next);
    }
}
