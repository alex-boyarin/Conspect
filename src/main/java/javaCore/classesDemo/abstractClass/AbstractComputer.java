package javaCore.classesDemo.abstractClass;

public abstract class AbstractComputer {
    private Ssd1 ssd1;
    private Ram1 ram1;

    public AbstractComputer(Ssd1 ssd1, Ram1 ram1) {
        this.ssd1 = ssd1;
        this.ram1 = ram1;
    }

    public abstract void load();

    public void print() {
        System.out.println("ssd " + ssd1.getValue() + ", ram " + ram1.getValue());
    }


    public Ssd1 getSsd1() {
        return ssd1;
    }

    public void setSsd1(Ssd1 ssd1) {
        this.ssd1 = ssd1;
    }

    public Ram1 getRam1() {
        return ram1;
    }

    public void setRam1(Ram1 ram1) {
        this.ram1 = ram1;
    }
}
