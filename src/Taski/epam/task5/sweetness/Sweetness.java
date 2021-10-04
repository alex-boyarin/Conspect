package Taski.epam.task5.sweetness;

public class Sweetness {
    private TypeSweetness typeSweetness;
    private double weight;
    private double sum;
    private int portion;

    public Sweetness(TypeSweetness typeSweetness, int portion) {
        this.typeSweetness = typeSweetness;
        this.portion = portion;
        this.sum = typeSweetness.getCost() * portion;
        this.weight = typeSweetness.getWeightGram() * portion;
    }

    public double getWeight() {
        return weight;
    }

    public double getSum() {
        return sum;
    }

    public int getPortion() {
        return portion;
    }


    @Override
    public String toString() {
        return typeSweetness.name() +
                "; weight:" + typeSweetness.getWeightGram() +
                "; price:" + typeSweetness.getCost() +
                ";\n portion=" + getPortion() +
                "\n Weight=" + getWeight() +
                "\n Sum=" + String.format("%.2f", getSum()) + "\n";
    }

    public static class Builder {
        private TypeSweetness typeSweetness;
        private double weight;
        private double sum;
        private int portion;

        public Builder typeSweetness(TypeSweetness typeSweetness) {
            this.typeSweetness = typeSweetness;
            return this;
        }

        public Builder weight(double weight) {
            this.weight = weight;
            return this;
        }

        public Builder sum(double sum) {
            this.sum = sum;
            return this;
        }

        public Builder portion(int portion) {
            this.portion = portion;
            return this;
        }

        public Sweetness build() {
            return new Sweetness(typeSweetness, portion);
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
