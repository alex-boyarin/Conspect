package utilConcurrent.lock.task;

public class Account1Demo {
    public static void main(String[] args) {
        Account1 account1 = new Account1(20000);
        Account1 account2 = new Account1(20000);
        Account1Thread account1Thread1 = new Account1Thread(account1, account2);
        Account1Thread account1Thread2 = new Account1Thread(account2, account1);
        account1Thread1.start();
        account1Thread2.start();
        try {
            account1Thread1.join();
            account1Thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(account1 + "\n" + account2);
    }
}
