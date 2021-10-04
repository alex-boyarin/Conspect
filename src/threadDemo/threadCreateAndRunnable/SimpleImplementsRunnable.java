package threadDemo.threadCreateAndRunnable;

/**
 * Создадим класс SimpleRunnable и он будет реализовывать интерфейс Runnable, он тоже из пакета
 * java.lang.  Это функциональный интерфейс и все что у него есть это метод run() который
 * ничего не принимает и ничего не возвращает. Т.е. это означает что отличий ни каких от нашего
 * класса Thread мы здесь так же можем написать
 * пример:  System.out.println("Hello from runnable:" +Thread.currentThread().getName());
 * <p>
 * Но так как мы реализовываем интерфейс а не extends то у нас нету никаких методов которые
 * мы могли унаследовать т.е. у нас нету метода getName() и т.д. которые мы видели в предыдущем
 * варианте  SimpleThread. Следовательно чтобы получить нам текущий поток который выполняет метод
 * run() мы должны все равно сделать Thread.currentThread().getName()
 * И так как это обычный класс здесь все точно так же как и в обычном классе.
 */
public class SimpleImplementsRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("Hello from runnable:" + Thread.currentThread().getName());
    }
    /**
     * Теперь возвращаемся к нашему ThreadDemo создадим еще оддин поток...->>
     */
}
