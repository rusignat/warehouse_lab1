package warehouse.valueProject;

public class Quantity {
    private int quantity;
    public Quantity(int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("Ошибка: количество не может быть отрицательным");
        }
        this.quantity = quantity;
    }

    public int getValue() {
        return quantity;
    }

    public void setValue(int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("Ошибка: количество не может быть отрицательным");
        }
        this.quantity = quantity;
    }

    public void changeQuantity(int delta) {
        if (quantity + delta < 0) {
            throw new IllegalArgumentException("Ошибка: такого количества товара нет на складе");
        }
        quantity += delta;
    }
}
