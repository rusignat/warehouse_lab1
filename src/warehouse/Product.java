package warehouse;

import warehouse.valueProject.Price;
import warehouse.valueProject.Quantity;
import warehouse.valueProject.Weight;

public abstract class Product {
    private final int id;
    private final String name, category;
    private final Quantity quantity;
    private Price price;
    private final Weight weight;

    private static int nextId = 1;

    private Storage storage;

    public Product(String name, String category, Quantity quantity, Price price, Weight weight) {
        id = nextId;
        nextId++;
        this.name = name;
        this.category = category;
        this.quantity = quantity;
        this.weight = weight;
        this.price = price;
    }

    public Quantity getQuantity() {return quantity;}
    public Price getPrice() {return price;}
    public int getId() {return id;}
    public Weight getWeight() {return weight;}
    public String getName() {return name;}
    public String getCategory() {return category;}

    public void setStorage(Storage storage) {this.storage = storage;}

    public void transferTo (Storage other) {
        Storage past = this.storage;
        if (other == this.storage) return;
        other.addProduct(this);
        if (past != null) {
            past.removeProduct(this);
        }
    }

    protected Product(Product other) {
        this.id = other.id;
        this.name = other.name;
        this.category = other.category;
        this.quantity = new Quantity(other.quantity.getValue());
        this.price = new Price(other.price.getValue());
        this.weight = new Weight(other.weight.getValue());

    }
    public abstract Product clone();

    public void changeQuantity(int delta) {quantity.changeQuantity(delta);}

    public void setPrice(Price price) {this.price = new Price(price.getValue());}

    @Override
    public String toString() {
        return "ID: " + id + " name: " + name + " category: " + category
                + " price: " + price.getValue() + "$ quantity: " + quantity.getValue()
                + " weight: " + weight.getValue() + " gram";
    }

}
