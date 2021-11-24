package javaCore.classesDemo.abstractClass;
/*
Абстрактный класс подобно каркасу для наших обьектов который который в последующем
мы будем использовать и наращивать его, более того абстрактные классы уже содержат
какое-то состояние т.е. какой-то набор полей.
 */
public class Start1 {
    public static void main(String[] args) {
        AbstractComputer laptop1 = new Laptop1(new Ssd1(500), new Ram1(8000), 3);
        AbstractComputer mobile1 = new Mobile1(new Ssd1(100), new Ram1(4000));
        loadComputers(laptop1, mobile1);
        printInformation(new AbstractComputer[]{laptop1, mobile1});

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
