package threadDemo.synchronizedMethod;

public class CounterThreadSynchro extends Thread {
    private CounterMethodSynchro counterMethodSynchro;

    public CounterThreadSynchro(CounterMethodSynchro counterMethodSynchro) {
        this.counterMethodSynchro = counterMethodSynchro;
    }

    @Override
    public void run() {
        for (int i = 0; i < 300; i++) {
            counterMethodSynchro.increment();
        }
    }
}
