package Taski.epam.task4.treasures;

import java.io.Serializable;

public class TreasureBronze extends Treasure implements Serializable {
    public TreasureBronze(int numberTreasure, String name, TypeTreasure typeTreasure, int cost) {
        super(numberTreasure, name, typeTreasure, cost);
    }
}
