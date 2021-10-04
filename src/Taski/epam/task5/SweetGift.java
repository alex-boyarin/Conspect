package Taski.epam.task5;

import Taski.epam.task5.sweetness.Sweetness;
import Taski.epam.task5.sweetness.TypeSweetness;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import static Taski.epam.task5.sweetness.TypeSweetness.*;


public class SweetGift {
    private final Map<TypeSweetness, Sweetness> sweetness;
    private double totalWeight;
    private double totalSumForSweetness;

    public SweetGift() {
        sweetness = new HashMap<>();
    }

    public void completeGift(String string, int portion) {
        if (string.toUpperCase(Locale.ROOT).contains(CAKE.name())) {
            addSweetness(CAKE.name(), portion);
        } else if (string.toUpperCase(Locale.ROOT).contains(CHOCOLATE.name())) {
            addSweetness(CHOCOLATE.name(), portion);
        } else if (string.toUpperCase(Locale.ROOT).contains(CANDYS.name())) {
            addSweetness(CANDYS.name(), portion);
        } else {
            System.out.println("Не верный ввод");
        }
    }

    private void addSweetness(String name, int portion) {
        TypeSweetness type = valueOf(name);
        if (sweetness.get(type) != null) {
            sweetness.computeIfPresent(type, ((typeSweetness, sweetness) -> Sweetness.builder()
                    .typeSweetness(type)
                    .sum(type.getCost() + sweetness.getSum())
                    .portion(sweetness.getPortion() + portion)
                    .weight(sweetness.getWeight() + type.getWeightGram())
                    .build()));
        } else {
            sweetness.putIfAbsent(type, new Sweetness(type, portion));
        }
    }

    public double getTotalWeight() {
        for (Sweetness Weight : sweetness.values()) {
            totalWeight += Weight.getWeight();
        }
        return totalWeight;
    }

    public double getTotalSumForSweetness() {
        for (Sweetness cost : sweetness.values()) {
            totalSumForSweetness += cost.getSum();
        }
        return totalSumForSweetness;
    }

    @Override
    public String toString() {
        String formatSum = String.format("%.2f", totalSumForSweetness);
        return "SweetGift " + sweetness + "\n" +
                "total weight=" + totalWeight +
                "\ntotal sum for sweetness=" + formatSum;
    }
}
