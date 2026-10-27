package warehouse.valueProject;

public class Price {
    private int price;
    public Price(int price) {
        if (price < 0) {
            throw new IllegalArgumentException("Ошибка: цена не может быть отрицательным");
        }
        this.price = price;
    }

    public int getValue() {
        return price;
    }

    public void setValue(int price) {
        if (price < 0) {
            throw new IllegalArgumentException("Ошибка: цена не может быть отрицательным");
        }
        this.price = price;
    }
}
