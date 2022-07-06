package javaCore.classesDemo.abstractClass;
/*
Абстрактный класс подобно каркасу для наших объектов который в последующем
мы будем использовать и наращивать его, более того абстрактные классы уже содержат
какое-то состояние т.е. какой-то набор полей.
 */
public class Start {
    public static void main(String[] args) {
        AbstractComputer laptop = new Laptop(new Ssd(500), new Ram(8000), 3);
        AbstractComputer mobile = new Mobile(new Ssd(100), new Ram(4000));
        loadComputers(laptop, mobile);
        printInformation(new AbstractComputer[]{laptop, mobile});

    }

    public static void printInformation(AbstractComputer[] computers) {
        for (AbstractComputer computer : computers) {
            computer.print();
        }
    }

    public static void loadComputers(AbstractComputer... computers) {
        for (AbstractComputer computer : computers) {
            computer.load();
            System.out.println();
        }
    }
}
