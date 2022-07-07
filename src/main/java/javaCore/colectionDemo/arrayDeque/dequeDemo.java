package javaCore.colectionDemo.arrayDeque;

import java.util.ArrayDeque;
import java.util.Deque;
/** Deque<Integer> deque = new ArrayDeque<>();--первый зашел первый вышел. */
public class dequeDemo {
    public static void main(String[] args) {
        Deque<Integer> deque = new ArrayDeque<>();//первый зашел, первый вышел.
        deque.offer(11);// метод добавления.
        deque.offer(22);
        deque.offer(33);
        deque.offer(44);
        while (!deque.isEmpty()) {
            System.out.println(deque.poll());
        }
    }
}
