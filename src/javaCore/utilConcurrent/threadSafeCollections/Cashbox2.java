package javaCore.utilConcurrent.threadSafeCollections;

public class Cashbox2 {
    private static int generator = 1;
    private int id;

    public Cashbox2() {
        this.id = generator++;
    }

    @Override
    public String toString() {
        return "Cashbox2{" +
                "id=" + id +
                '}';
    }
}
