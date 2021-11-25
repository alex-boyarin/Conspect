package javaCore.classesDemo.abstractClass;

public class Laptop1 extends AbstractComputer {
    private int weight;

    public Laptop1(Ssd1 ssd1, Ram1 ram1, int weight) {
        super(ssd1, ram1);
        this.weight = weight;
    }

    @Override
    public void load() {
        open();
        System.out.println("Я загрузился");
    }

    @Override
    public void print() {
        super.print();
        System.out.println(", weight kg: " + weight);
    }

    public void open() {
        System.out.println("я открыл крышку");
    }
}
