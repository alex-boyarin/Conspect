package javaCore.classesDemo.instanceOf;

public abstract class AbstractComputer {
    private Ssd ssd;
    private Ram ram;

    public AbstractComputer(Ssd ssd, Ram ram) {
        this.ssd = ssd;
        this.ram = ram;
    }

    public abstract void load();


    public void info() {
        System.out.println("ssd " + ssd.getValue() +
                           ", ram " + ram.getValue());
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

