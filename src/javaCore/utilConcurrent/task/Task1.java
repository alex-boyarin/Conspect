package javaCore.utilConcurrent.task;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Написать программу, бесконечно считывающую пользовательские числа из консоли. Эти числа представляют
 * собой кол-во секунд. При каждом вводе числа, должна создаваться задача, которая засыпает на введенное
 * число секунд и затем выводит "Я спал № секунд". Однако нужно сделать так, чтобы все задачи
 * выполнялись в одном и том же потоке в порядке ввода. Т.е. в программе есть 2 потока: главный и поток
 * для выполнения всех задач по очереди. При вводе отрицательного числа программа должна завершать свою
 * работу. Второе решение- несколько потоков в пуле. Посчитать кол-во обработаных задач каждым потоком.
 */
public class Task1 {
    public static void main(String[] args) throws InterruptedException {
        //будем использовать newSingleThreadExecutor() т.к. по условию у нас один поток
        // ExecutorService threadExecutor = Executors.newSingleThreadExecutor();
        ExecutorService threadExecutor = Executors.newFixedThreadPool(2);//второе решение задачи
        /*
        Для того чтобы посчитать кол-во решеных задач каждым потоком будем использовать ThreadLocal<T>
        переменные, суть ThreadLocal в том что он хранит для каждого потока свое значение которым
        его параметризовали.
         */
        ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int seconds = scanner.nextInt();
            if (seconds < 0) {
                break;
            }
            threadExecutor.submit(() -> {
                Integer counter = threadLocal.get();//получаем кол-во задач
                threadLocal.set(counter == null ? 1 : ++counter);
                System.out.println(String.format("Thread '%s', tasks: '%d'", Thread.currentThread().getName(), threadLocal.get()));
                Thread.sleep(seconds * 1000L);
                System.out.println(String.format("Thread '%s' sleep '%d' second", Thread.currentThread().getName(), seconds));
                return seconds;
            });
        }
        /*
        Как только мы вышли из нашего цикла, мы говорим заверши пожалуйста все задачи которые у тебя
        есть сейчас.
         */
        threadExecutor.shutdown();
        threadExecutor.awaitTermination(10L, TimeUnit.MINUTES);
    }
}
