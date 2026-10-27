package warehouse;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class WarehouseIterator implements Iterator<Product> {
    private final ArrayList<Product> products;
    private int currentIndex = 0;

    public  WarehouseIterator(ArrayList<Product> products) {
        this.products = products;
    }

    @Override
    public boolean hasNext() {
        return currentIndex != products.size();
    }

    @Override
    public Product next() {
        if (!hasNext()) {
            throw new NoSuchElementException("Ошибка: больше товаров нет");
        }
        return products.get(currentIndex++);
    }
}
