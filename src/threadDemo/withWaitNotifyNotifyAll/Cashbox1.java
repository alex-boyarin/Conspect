package threadDemo.withWaitNotifyNotifyAll;

public class Cashbox1 {
    private static int generator = 1;
    private int id;

    public Cashbox1() {
        this.id = generator++;
    }

    @Override
    public String toString() {
        return "Cashbox1{" +
                "id=" + id +
                '}';
    }
}
