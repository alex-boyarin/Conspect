package Taski.epam.task4.treasures;

import java.io.Serializable;

public class TreasureGold extends Treasure implements Serializable {
    public TreasureGold(int numberTreasure, String name, TypeTreasure typeTreasure, int cost) {
        super(numberTreasure, name, typeTreasure, cost);
    }
}
