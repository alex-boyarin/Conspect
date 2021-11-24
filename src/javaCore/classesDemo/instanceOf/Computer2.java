package javaCore.classesDemo.instanceOf;

public abstract class Computer2 {
    private Ssd2 ssd2;
    private Ram2 ram2;

    public Computer2(Ssd2 ssd2, Ram2 ram2) {
        this.ssd2 = ssd2;
        this.ram2 = ram2;
    }

    public abstract void load();


    public void print() {
        System.out.println("ssd " + ssd2.getValue() +
                ", ram " + ram2.getValue());
    }

    public Ssd2 getSsd2() {
        return ssd2;
    }

    public void setSsd2(Ssd2 ssd2) {
        this.ssd2 = ssd2;
    }

    public Ram2 getRam2() {
        return ram2;
    }

    public void setRam2(Ram2 ram2) {
        this.ram2 = ram2;
    }
}

