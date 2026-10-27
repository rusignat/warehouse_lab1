package warehouse;

import java.lang.Iterable;
import java.util.ArrayList;
import java.util.Iterator;

public class Warehouse implements Storage, Iterable<Product> {
    private final ArrayList<Product> products;
    private final int maxSize;
    private int currentSize;

    public Warehouse(int maxSize) {
        if (maxSize <= 0) {
            throw new IllegalArgumentException("Ошибка: Склад не может иметь размер меньше 1");
        }
        this.maxSize = maxSize;
        this.products = new ArrayList<>();
        this.currentSize = 0;
    }

    public Warehouse(Warehouse other) {
        this.currentSize = 0;
        this.maxSize = other.maxSize;
        this.products = new ArrayList<>();
        for (Product copyProduct : other.products) {
            addProduct(copyProduct.clone());
        }
    }

    @Override
    public void addProduct (Product product) {
        if (currentSize >= maxSize) {
            throw new IllegalArgumentException("Ошибка: Склад уже заполнен");
        }
        products.add(product);
        product.setStorage(this);
        currentSize++;
    }

    @Override
    public void removeProduct (Product product) {
        if (currentSize == 0) {
            throw new IllegalArgumentException("Ошибка: удаление невозможно, склад пуст");
        }
        if (!products.remove(product)) {
            throw new IllegalArgumentException("Ошибка: данного товара нет на складе");
        }
        currentSize--;
    }

    public void removeById (int id) {
        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            if (product.getId() == id) {
                products.remove(i);
                product.setStorage(null);
                currentSize--;
                return;
            }
        }
        throw new IllegalArgumentException("Ошибка: товара с таким ID не существует в этом складе");
    }

    public void removeByIndex(int index) {
        if (index >= currentSize || index < 0) {
            throw new IndexOutOfBoundsException("Ошибка: index должен быть больше либо равен 0 и меньше количество товара на складе");
        }
        products.get(index).setStorage(null);
        products.remove(index);
        currentSize--;
    }

    public Product findById (int id) {
        for (Product product: products) {
            if (product.getId() == id) return product;
        }
        return null;
    }

    public ArrayList<Product> findByCategory(String category) {
        ArrayList<Product> productsByCategory = new ArrayList<>();
        for (Product product: products) {
            if (product.getCategory().equals(category)) {
                productsByCategory.add(product);
            }
        }
        return productsByCategory;
    }

    public ArrayList<Product> findByPrice(int price) {
        ArrayList<Product> productsByPrice = new ArrayList<>();
        for (Product product: products) {
            if (product.getPrice().getValue() == price) {
                productsByPrice.add(product);
            }
        }
        return productsByPrice;
    }

    public void transferFrom(Warehouse other) {
        if (other == this) return;
        while (this.currentSize < this.maxSize && other.currentSize != 0) {
            Product product = other.products.getFirst();
            this.addProduct(product);
            other.removeProduct(product);
        }
    }

    @Override
    public Iterator<Product> iterator() {
        return new WarehouseIterator(products);
    }

}
