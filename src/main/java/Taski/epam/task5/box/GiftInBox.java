package Taski.epam.task5.box;

import Taski.epam.task5.SweetGift;

import static Taski.epam.task5.box.TypeBox.*;

public class GiftInBox {
    private TypeBox typeBox;
    private SweetGift sweetGift;
    private double totalCost;

    public GiftInBox(SweetGift sweetGift) {
        this.sweetGift = sweetGift;
        this.typeBox = completeBox();
        this.totalCost = typeBox.getCostBox() + sweetGift.getTotalSumForSweetness();
    }

    private TypeBox completeBox() {
        double wightInKilo = sweetGift.getTotalWeight() / 1000;
        if (wightInKilo <= SMALL_BOX.getMaxWeightKilogram()) {
            return SMALL_BOX;
        }
        if (wightInKilo > SMALL_BOX.getMaxWeightKilogram() && wightInKilo <= MIDDLE_BOX.getMaxWeightKilogram()) {
            return MIDDLE_BOX;
        } else {
            return BIG_BOX;
        }
    }

    @Override
    public String toString() {
        return typeBox.name() + " cost:" + typeBox.getCostBox() +
                "\n " + sweetGift +
                "\n total cost=" + String.format("%.2f", totalCost);
    }
}
