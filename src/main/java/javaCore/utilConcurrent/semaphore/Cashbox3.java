package javaCore.utilConcurrent.semaphore;

public class Cashbox3 { private static int generator = 1;
    private int id;

    public Cashbox3() {
        this.id = generator++;
    }

    @Override
    public String toString() {
        return "Cashbox3{" +
                "id=" + id +
                '}';
    }
}
