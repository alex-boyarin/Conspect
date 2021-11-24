package javaCore.classesDemo.instanceOf;

public final class Laptop2 extends Computer2{
    private int weight2;

    public Laptop2(Ssd2 ssd2, Ram2 ram2, int weight) {
        super(ssd2, ram2);
        this.weight2 = weight;
    }

    @Override
    public void load() {
        open();
        System.out.println("Я загрузился");
    }

    @Override
    public void print() {
        super.print();
        System.out.println(", weight kg: " + weight2);
    }

    public void open() {
        System.out.println("я открыл крышку");
    }

    public int getWeight2() {
        return weight2;
    }

    public void setWeight2(int weight) {
        this.weight2 = weight;
    }
}
