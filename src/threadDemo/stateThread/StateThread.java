package threadDemo.stateThread;

import threadDemo.threadCreateAndRunnable.SimpleExtendsThread;
import threadDemo.threadCreateAndRunnable.SimpleImplementsRunnable;

public class StateThread {//состояние потока
    /**
     * Что такое состояние потока?
     * Дело в том что у каждого потока есть состояние в определенный момент времени
     * На примере SimpleThread т.е. когда мы только создали его, мы можем обращаться
     * к ссылке simpleThread чтобы извлекать информацию о нем, в данном случае мы можем
     * получить simpleThread.getState()-состояние потока.
     * Обьект типа State()-это обычный enum, и какие варианты есть в нем
     * NEW-Состояние потока для еще не запущенного потока.
     * <p>
     * RUNNABLE-как только мы его запустили .start() мы видим RUNNABLE.
     * <p>
     * BLOCKED-это означает что поток блокирован, он не может совершить какое-то действие
     * до тех пор пока действие не совершит другой поток.
     * <p>
     * WAITING-говорит о том что поток ждет выполнения чего либо,
     * есть несколько вариантов чтобы получить это состояние, но одно из них мы уже прошли
     * это .join() когда например наш поток main() вызвал join() у обьекта другого потока
     * он находится в состоянии WAITING т.е. до тех пор пока тот поток у которого был вызван
     * этот метод не закончит своего выполнения, наш main() в состоянии WAITING.
     * <p>
     * TIMED_WAITING-в этом варианте мы можем задавать определеное кол-во секунд
     * которое мы можем ждать, и так же мы в методе join() можем передать милисекунды, как
     * долго мы будем ждать.
     * <p>
     * TERMINATED-после того как наш поток закончит выполнение он становится TERMINATED
     */
    public static void main(String[] args) {
        var simpleExtendsThread = new SimpleExtendsThread();
        //текущее состояние нашего потока simpleExtendsThread.getState()
        System.out.println(simpleExtendsThread.getName() + " " + simpleExtendsThread.getState());
        var runnableThread = new Thread(new SimpleImplementsRunnable(), "my name");
        var lambdaThread = new Thread(() -> System.out.println("Hello from lambda: " + Thread.currentThread().getName()));

        simpleExtendsThread.start();
        //после этого мы стартуем и выводим состояние еще раз simpleExtendsThread.getState()
        System.out.println(simpleExtendsThread.getName() + " " + simpleExtendsThread.getState());
        runnableThread.start();
        lambdaThread.start();
        try {
            simpleExtendsThread.join(100L);
            //после того как вызвали метод join() и перешли на следущую строчку следовательно
            //simpleExtendsThread закончил его, и мы ожидаем получить состояние потока
            System.out.println(simpleExtendsThread.getName() + " " + simpleExtendsThread.getState());
            runnableThread.join();
            lambdaThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName());
    }
}
/**
 * Мы не можем остановить поток, но мы можем попросить его остановиться вызвав метод interrupt()
 */