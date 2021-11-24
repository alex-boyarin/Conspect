package javaCore.classesDemo.proInterfece;

public class Mobile extends Computer {
    public Mobile(Ssd ssd, Ram ram) {
        super(ssd, ram);
    }

    @Override
    public void load() {
        System.out.println("Я включился");
    }
}
