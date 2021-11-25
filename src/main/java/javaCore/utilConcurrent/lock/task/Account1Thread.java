package javaCore.utilConcurrent.lock.task;

public class Account1Thread extends Thread {
    private final Account1 accountFrom;
    private final Account1 accountTo;

    public Account1Thread(Account1 accountFrom, Account1 accountTo) {
        this.accountFrom = accountFrom;
        this.accountTo = accountTo;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3000; i++) {
            /*
           Решаем проблему с блокировкой наших потоков, для этого мы убираем синхрон. блоки.
           Делаем метод для того чтобы лочить наши Account1, lockAccounts() И если получилось
           заблокировать наши Account1, то мы делаем операции снятие и зачисление на счета.
             */
            lockAccounts();
            try {
                if (accountFrom.takeOff(10)) {
                    accountTo.add(10);
                }
            } finally {
                accountFrom.getLock().unlock();
                accountTo.getLock().unlock();
            }
        }
    }

    /*
В методе делаем бесконечный цикл. т.е. по аналогии с atomic. До тех пор пока у нас не получилось
захватить мониторы у двоих акаунтов мы не сможем перечислить деньги, следовательно у нас есть теперь
accountFrom.getLock() и accountTo.getLock().после точки у нас всплвывает список методов которые доступны.
                Из них:
    unlock()-отпускает монитор если он захвачен (НЕ ВЫЗЫВАТЬ ЕГО !!! ЕСЛИ МЫ НЕ ЗАХВАТИЛИ МОНИТОР)
потому-что мы не можем его отпустить.
    tryLock()-возвращает булево значение, получилось ли захватить монитор или нет
    tryLock(long time, TimeUnit unit)-так же можем вызвать с каким-то временем,
TimeUnit unit-единицы измерения(часы, минуты, секунды, милисекунды...)
    lock()-основной метод который захватывае монитор нашего Account, отличие лишь в том что он ждет
пока не получится захватить монитор, а tryLock()-пытается захватить монитор.
    newCondition()-можно создавать на каждый lock новое условие, которое можно к примеру использовать
для ожидания чего либо, по сути это аналогия нашего класса Object точнее его методов wait()? notify()
через него можем вызывать методы ожидания.

     */
        /*
        Нам нужно пытаться захватить монитор сразу у двух Account1.
Если у нас не получилось захватить монитор у какого либо Account1  мы должны его отпустить.
Нам нельзя ждать освобождения второго Account1 если мы захватили первый, иначе мы можем попасть в
проблему с deadLock/
         */
    private void lockAccounts() {
        while (true) {
            boolean fromLockResult = accountFrom.getLock().tryLock();
            boolean toLockResult = accountTo.getLock().tryLock();
            if (fromLockResult && toLockResult) {
                break;
            }
            if (fromLockResult) {
                accountFrom.getLock().unlock();
            }
            if (toLockResult) {
                accountTo.getLock().unlock();
            }
        }
    }
}
