package javaCore.classesDemo.abstractClass;
/*
Абстрактный класс подобно каркасу для наших объектов который в последующем
мы будем использовать и наращивать его, более того абстрактные классы уже содержат
какое-то состояние т.е. какой-то набор полей.
 */
public abstract class AbstractComputer {
    private Ssd ssd;
    private Ram ram;

    public AbstractComputer(Ssd ssd, Ram ram) {
        this.ssd = ssd;
        this.ram = ram;
    }

    public abstract void load();

    public void print() {
        System.out.println("ssd " + ssd.getValue() + ", ram " + ram.getValue());
    }


    public Ssd getSsd() {
        return ssd;
    }

    public void setSsd(Ssd ssd) {
        this.ssd = ssd;
    }

    public Ram getRam() {
        return ram;
    }

    public void setRam(Ram ram) {
        this.ram = ram;
    }
}
