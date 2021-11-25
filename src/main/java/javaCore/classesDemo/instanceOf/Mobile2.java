package javaCore.classesDemo.instanceOf;

public class Mobile2 extends Computer2 {
    public Mobile2(Ssd2 ssd2, Ram2 ram2) {
        super(ssd2, ram2);
    }

    @Override
    public void load() {
        System.out.println("Я включился");
    }
}
