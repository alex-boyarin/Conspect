package Taski.epam.task4.treasures;

import java.io.Serializable;

public abstract class Treasure implements Serializable {
    private int numberTreasure;
    private String name;
    private TypeTreasure typeTreasure;
    private int cost;

    public Treasure(int numberTreasure, String name, TypeTreasure typeTreasure, int cost) {
        this.numberTreasure = numberTreasure;
        this.name = name;
        this.typeTreasure = typeTreasure;
        this.cost = cost;
    }

    public TypeTreasure getTypeTreasure() {
        return typeTreasure;
    }

    public void setTypeTreasure(TypeTreasure typeTreasure) {
        this.typeTreasure = typeTreasure;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }


    @Override
    public String toString() {
        return "Treasure №" + numberTreasure + " " + typeTreasure + " " + name +
                " cost=" + cost;
    }
}
