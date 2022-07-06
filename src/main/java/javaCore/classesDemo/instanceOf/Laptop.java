package javaCore.classesDemo.instanceOf;

public final class Laptop extends AbstractComputer {
    private int weight;

    public Laptop(Ssd ssd, Ram ram, int weight) {
        super(ssd, ram);
        this.weight = weight;
    }

    @Override
    public void load() {
        open();
        System.out.println("Я загрузился");
    }

    @Override
    public void info() {
        super.info();
        System.out.println(", weight kg: " + weight);
    }

    public void open() {
        System.out.println("я открыл крышку");
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
