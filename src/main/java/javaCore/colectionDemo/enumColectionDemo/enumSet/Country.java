package javaCore.colectionDemo.enumColectionDemo.enumSet;

public enum Country {
    ARMENIA(3, 28470),
    BELARUS(9, 202910),
    INDIA(1370, 2973190),
    KAZAKHSTAN(18, 2699700),
    POLAND(38, 306230),
    UKRAINE(43, 576320);
    private int population;
    private int landArea;

    Country(int population, int landArea) {
        this.population = population;
        this.landArea = landArea;
    }

    public void grow(int additionalPopulation) {//grow - расти
        population += additionalPopulation;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public int getLandArea() {
        return landArea;
    }

    public void setLandArea(int landArea) {
        this.landArea = landArea;
    }
}
