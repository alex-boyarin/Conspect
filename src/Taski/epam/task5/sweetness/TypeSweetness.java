package Taski.epam.task5.sweetness;

public enum TypeSweetness {
    CHOCOLATE(100, 2.5),
    CAKE(900, 15),
    CANDYS(100, 3);
    private final double weightGram;
    private final double cost;

    TypeSweetness(double weightGram, double cost) {
        this.weightGram = weightGram;
        this.cost = cost;
    }

    public double getWeightGram() {
        return weightGram;
    }

    public double getCost() {
        return cost;
    }
}
