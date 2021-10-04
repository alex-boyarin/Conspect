package colectionDemo.priorityQueueDemo;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/* Преоритетная очередь следует правилу, элем. добавляется в позицию с точки зрения сортировки,
 сортировка обязательно должна быть задана*/
public class PriorityQueueDemo {
    public static void main(String[] args) {
        Queue<String> prior = new PriorityQueue<>(Comparator.reverseOrder());
        prior.offer("j");
        prior.offer("a");
        prior.offer("v");
        prior.offer("a");
        prior.offer("2");
        while (!prior.isEmpty()) {
            System.out.println(prior.poll());
        }
    }
}
