package javaCore.colectionDemo.priorityQueueDemo;

import java.util.*;

/* Приоритетная очередь следует правилу, элемент добавляется в позицию с точки зрения сортировки,
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
       // Collection<E>
        //List<E>
        //Set<E>
        //Queue<E>
        //Map<K,V>



    }
}
