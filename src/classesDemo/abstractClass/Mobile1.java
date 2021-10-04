package classesDemo.abstractClass;

public class Mobile1 extends AbstractComputer {
    public Mobile1(Ssd1 ssd, Ram1 ram) {
        super(ssd, ram);
    }

    @Override
    public void load() {
        System.out.println("Я включился");
    }
}
