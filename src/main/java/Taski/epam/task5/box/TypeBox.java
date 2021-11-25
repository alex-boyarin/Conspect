package Taski.epam.task5.box;

public enum TypeBox {
    SMALL_BOX(1, 3),
    MIDDLE_BOX(5, 12),
    BIG_BOX(10, 28);
    private final int maxWeightKilogram;
    private int costBox;

    TypeBox(int maxWeightKilogram, int costBox) {
        this.maxWeightKilogram = maxWeightKilogram;
        this.costBox = costBox;
    }

    public int getMaxWeightKilogram() {
        return maxWeightKilogram;
    }

    public int getCostBox() {
        return costBox;
    }

    @Override
    public String toString() {
        return "TypeBox" +
                "maxWeightKilogram=" + maxWeightKilogram +
                ", costBox=" + costBox;
    }
}
