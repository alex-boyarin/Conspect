package javaCore.lll1234.computer;

public class Computer {
    private Ssd ssd;
    private Ram ram;
    private static int counter = 0;

    public Computer(Ssd ssd, Ram ram) {
        this.ssd = ssd;
        this.ram = ram;
        counter++;
    }

    public static int getCounter() {
        return counter;
    }

    public void printState() {
        System.out.println("Computer: ram " + ram.getValue() + ", ssd" + ssd.getValue());
    }

    public Computer() {
        System.out.println("Я был создан");
    }

    void load() {
        System.out.println("Я загрузился");
    }

    void load(boolean open) {
        System.out.println("Я загрузился");
        if (open) {
            System.out.println("Я открыл крышку");
        }
    }
}
