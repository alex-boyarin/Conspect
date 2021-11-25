package Taski.epam.task4.treasures;

import java.io.Serializable;

public class TreasureSilver extends Treasure implements Serializable {
    public TreasureSilver(int numberTreasure, String name, TypeTreasure typeTreasure, int cost) {
        super(numberTreasure, name, typeTreasure, cost);
    }
}
