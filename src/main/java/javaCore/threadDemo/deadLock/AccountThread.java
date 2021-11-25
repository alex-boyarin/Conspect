package javaCore.threadDemo.deadLock;

public class AccountThread extends Thread {
    private final Account accountFrom;
    private final Account accountTo;

    public AccountThread(Account accountFrom, Account accountTo) {
        this.accountFrom = accountFrom;
        this.accountTo = accountTo;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20000; i++) {
            /*
            В блоке синхрон. мы можем захватить только один монитор, следовательно
            чтобы захватить два монитора нам нужно вложить один блок в другой
             */
            synchronized (accountFrom) {
                synchronized (accountTo) {
                    if (accountFrom.takeOff(10)) {
                        accountTo.add(10);
                    }
                }
            }
        }
    }
}
