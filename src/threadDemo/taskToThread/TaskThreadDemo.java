package threadDemo.taskToThread;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Задан LinkedList, представляющий собой хранилище целых чисел. Поток producerThread с каккой-то
 * переодичностью бесконечно добавляет в этот список случайные числа, однако максимальное кол-во,
 * которое он может добавить равно 10.
 * <p>
 * Поток consumerThread бесконечно считывает числа с какой-то случайной задержкой (от 0 до 10 мс)
 * <p>
 * Сделать так, чтобы метод producer добавлял числа только тогда, когда не превышен лимит, а метод
 * consume забирал их только тогда, когда в списке что-нибудь есть. При этом методы должны корректно
 * работать в многопоточной среде.
 * <p>
 * Создать и запустить два различных потока, один из которых вызывае produce, а другой consume.
 * Продемонстрировать корректность работы хранилища спомощью вывода сообщений в консоль о добавлении,
 * получении и текущем размере хранилища на этапах добавления и получения.
 */
public class TaskThreadDemo {
    public static void main(String[] args) {
        Queue<Integer> queue = new ArrayDeque<>();
        Thread producerThread = new Thread(new ProducerThread(queue));
        Thread consumerThread = new Thread(new ConsumerThread(queue));

        producerThread.start();
        consumerThread.start();
        try {
            producerThread.join();
            consumerThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
