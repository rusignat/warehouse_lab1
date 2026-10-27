package warehouse.valueProject;

public class Weight {
    private double weight;
    public Weight(double weight) {
        if (weight < 0) {
            throw new IllegalArgumentException("Ошибка: масса не может быть отрицательным");
        }
        this.weight = weight;
    }

    public double getValue() {
        return weight;
    }

    public void setValue(double weight) {
        if (weight < 0) {
            throw new IllegalArgumentException("Ошибка: масса не может быть отрицательным");
        }
        this.weight = weight;
    }

}
