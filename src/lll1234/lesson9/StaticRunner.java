package lll1234.lesson9;

import lll1234.computer.Computer;

public class StaticRunner {
    public static void main(String[] args) {
        Computer computer = new Computer(null, null);
        Computer computer1 = new Computer(null, null);
        new Computer(null, null);
        new Computer(null, null);
        new Computer(null, null);
        System.out.println(Computer.getCounter());
        Class<? extends Computer> aClass = computer.getClass();
        Class<? extends Computer> aClass1 = computer1.getClass();
        System.out.println(aClass == aClass1);
        System.out.println(computer == computer1);
    }
}
