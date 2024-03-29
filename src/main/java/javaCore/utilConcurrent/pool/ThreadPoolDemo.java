package javaCore.utilConcurrent.pool;

import java.util.concurrent.Executors;

/**
 * Пулы потоков это всего лишь какое-то множествообьектов типа Thread, которое мы можем использоватьдля
 * выполнения задач. Для чего они нужны? Дело в том что само создание потока занимает какое-то время
 * т.е. это трудозатратноя операция мы помним на примере тех же самых акаунтов  когда мы создаем
 * новый поток new AccountThread и запускаем его, мы не вызываем метод run() который основной, который
 * выполняет нашу задачу, потому-что он вызывается автоматически как только наш поток был создан
 * jvm. Следовательно чтобы оптимизировать эту работу и не создавать потоки каждый раз заново мы
 * можем создать их всего лишь один раз, запихнув их в какую-то структуру так называемый
 * пул потоков и просто скармливать наши задачи, наш Runnable для того чтобы какой-то из этих потоков
 * когда он свободен ее выполнял. Рассмотрим на примере как работают Thread pool
 * <p>
 * У нас есть для пулов потоков так называемы экзекьюторы Executors
 * И для создания этих пулов у нас есть улитный класс Executors, и у нас есть 5 разных вариантов создания
 * пулов первые 3 будут самые часто встречаемые.
 * <p>
 * newSingleThreadExecutor()-создает нам threadPool который состоит всего лишь из одного потока.
 * <p>
 * newFixedThreadPool(кол-во потоков)-создает столько потоков сколько мы передали в метод.
 * <p>
 * newCachedThreadPool()- он отличается тем что он безграничный т.е. сколько задач мы отправим, столько
 * потоков и будет создано, но если мы отправили 5 задач в наш пул, и у нас создалось 5 потоков на
 * каждую из этих задач, следующий раз если мы отправим 1,2,3,4 или 5 задач то новые потоки не будут
 * создаваться, они будут просто браться из нашего пула, но если бы мы отправили одновремено 7 задач
 * то в нашем пуле есть только 5 за кешированых потоков, следовательно уу нас не хватает потоков
 * чтобы выполнить оставшиеся 2 задачи, слеловательно они тоже будут созданы.
 * <p>
 * newScheduledThreadPool(кол-во потоков)-"новый пул запланированных потоков" то же можем передать
 * кол-во потоков, суть в том что мы можем выполнять задачи с задержкой delay или како-то переодичностью,
 * например мы хотим каждые 3 часа запускать какуе-то задачу напримет для обновления информации о нашем
 * пользователе, либо для удаление не нужных файлов на компьютере.
 * <p>
 * newWorkStealingPool()-он создает ThreadPool на основании уже другой реализации пула это JoinPool
 * суть в том что он создает пул такого размера какой у вас позволяет кол-во процессоров, т.е. через
 * обьект Runtime.getRuntime().availableProcessors() мы можем получить кол-во свободных процессоров
 * у нашего компьютора, на основании этого значения мы можем создать пул из оптимального количества
 * потоков оно не обязательно будет равно кол-ву процессоров доступных, поэтому можно не переживать
 * на счет определения кол-ва потоков если мы хотим просто создать пул с оптимальным кол-вом потоков
 * на основании мощьности компьютера.
 */
public class ThreadPoolDemo {
    public static void main(String[] args) {
        Executors.newSingleThreadExecutor();
        Executors.newFixedThreadPool(5);
        Executors.newCachedThreadPool();
        Executors.newScheduledThreadPool(3);
        Executors.newWorkStealingPool();
    }
}
