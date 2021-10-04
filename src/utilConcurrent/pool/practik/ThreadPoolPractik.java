package utilConcurrent.pool.practik;

import java.util.concurrent.*;

/**
 * Какие у threadPool есть методы:
 * 1) submit(Runnable task)-(подавать, подчиняться..)отправляем задачу на выполнение.
 * Интерфейс Runnable мы передавали в обьект Thread в качестве параметра в конструктор.
 * <p>
 * 2) submit(Callable<T> task)-Callable эдентичен Runnable, и все что он делает это возвращает какой-то
 * результат, как видно он параметризов. <T> мы сами выбираем что это может быть за обьект. Поэтому
 * используем Callable всегда когда нам нужен результат выполнения.
 * <p>
 * 3) submit(Runnable task, T result)-он так же ничем не отличается от первой реализации, но result он
 * возвращает в том случае если task-ом выполнилось, т.е. просто какое-то за-харткодженое значение
 * которое мы хотели получить если бы task выполнил свое значение.
 * <p>
 * execute(Runnable command)-(выполнять)-если нам не нужен возвращаемый результат.
 */
public class ThreadPoolPractik {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ScheduledExecutorService threadPool = Executors.newScheduledThreadPool(4);
//schedule(Runnable command, long delay, Timeout unt) в методе указываем команду,
// количество времени задержки, тип времени.
        threadPool.schedule(() -> System.out.println("java"), 3L, TimeUnit.SECONDS);
        threadPool.shutdown();//ждет выполнение всех задач
        threadPool.awaitTermination(1L, TimeUnit.HOURS);//время ожидания
        test();
        ScheduledExecutorService threadPool1 = Executors.newScheduledThreadPool(4);
// scheduleAtFixedRate-этот метод используется для цикличного выполнения программы, и после него
// не требуется вызов shutdown()
        threadPool1.scheduleAtFixedRate(() -> System.out.println("ok"), 100L, 200L, TimeUnit.MILLISECONDS);
    }

    /*
Попробуем submit(Callable<T> task) т.к. это функц. интерфейс он ничем не отлич. от Runnable кроме возвр.
знач. будем использ. лямбда выражение. Для интереса выведем на консоль значение. И возвращается какое-то
значение future. Задача будет сразу отправлена на выполнение после того как мы вызвали метод submit()
естественно если в нашем пуле есть мвободные потоки, если их нет то эта задача будет ожидать.
Что делать если когда мы хотим threadPool завершить. В реальных приложениях делают 1 или 2
максимум 3 threadPool, и их используют для любых задач, потому-что они так часто и не нужны на самом
деле, и никогда их не завершают. Т.е. никогда не создают их как локальные переменные,
а обычно это поля каких-то обьектов либо даже статические поля. Но если на нужно завершить пул,
у threadPool есть метод shutdown()-этот метод ждет выполнение всех задач которые мы отправили в threadPool.
shutdownNow()-завершает все потоки и возвращает те задачи что не успели выполниться.

Для того чтобы указать время ожидания, ведь метод shutdown() может быть невероятно долгим, у threadPool
есть метод awaitTermination(long timeout, TimeUnit unit)-где мы указываем время timeout
тип времени (час, минуты, секунды...)
     */
    private static void test() throws InterruptedException, ExecutionException {
        ExecutorService threadPool = Executors.newFixedThreadPool(5);
     /*
Future-это обычный обьект, и мы не останавливаемся в строчке после того как отправили задачу на
выполнение submit() в этом то и суть наших threadPool, мы просто передаем ему задачу он ее выполняет
и не останавливает главный поток main. Следовательно Future это обьект с  результатом выполнение
нашей задачи которой будет в будущем, поэтому чтобы получить этот результат выполнения,
мы можем это сделать в любом удобно месте для нас, например System.out.println("Result: " + future.get())
и только на вызове метода get() мы будем ожидать, так же есть метод get(long timeout, TimeUnit unit)
где мы указываем кол-во времени и тип(час, мин., сек...) сколько мы будем ждать, следовательно
метод get() является блокирующим, он блокирует наш поток main.
      */
        Future<Integer> future = threadPool.submit(() -> {
            Thread.sleep(2000L);//выполнение потока останавливается
            System.out.println("It's callable");
            return 1;
        });
        /*
Основной реализацией Future является CompletableFuture и через точку получим список методов:
supplyAsync()-
         */
        //CompletableFuture.supplyAsync();
        System.out.println("Result: " + future.get());
        threadPool.shutdown();
        threadPool.awaitTermination(1L, TimeUnit.HOURS);
        System.out.println("main end");
    }
}
