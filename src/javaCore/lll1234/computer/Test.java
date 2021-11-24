package javaCore.lll1234.computer;

public class Test {
    public static void main(String[] args) {
        Ram ram = new Ram(1000);
        Ssd ssd = new Ssd(500);
        Computer computer = new Computer(ssd, ram);
        computer.printState();
        computer.load();
        computer.load(true);
    }
}
