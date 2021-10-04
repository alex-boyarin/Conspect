package colectionDemo.arrayDeque;

import java.util.ArrayDeque;
import java.util.Deque;

/* Коллекция позволяющая организовать поведение stack  Queue-очередь. Колекц. не синхронизированая,
 в эту колекцию нельзя добавлять Null, При создании возможно создание 3 конструкторов.
 Констр. по умолчанию создает резерв сразу 16 позиций, можно указать точное кол-во позиций,
 а также можно проинициализ. ArrayDeque другой кол-ей. */
public class ArrayDequeDemo {
    public static void main(String[] args) {/* Если использовать ArrayDeque в качестве stack это более
     выгодно с точки зрения скорости чем использования синхр. класса Stream*/
        ArrayDeque<Integer> stack = new ArrayDeque<>();//stack перевый зашел последний вышел.
        stack.push(1);//добавление элементов.
        stack.push(2);
        stack.push(3);
        while (!stack.isEmpty()) {//isEmpty-проверяет пустая кол-ия или нет.
            System.out.println(stack.pop());//извлечение стека, стек это первый зашел последний вышел.
        }
        /* В Java есть еще одна коллекция которая может вести себя как очередь это LinkedList
         и соостветственно в этом случае ArrayDeque так же рабртает быстрее чем LinkedList
         если используется как очередь. При превышении размеров установленых кол-во резервных
         ячеек автоматически увеличивается в двое.
         */
        Deque<Integer> deque = new ArrayDeque<>();//первый зашел первый вышел.
        deque.offer(11);// метод добавления.
        deque.offer(22);
        deque.offer(33);
        while (!deque.isEmpty()) {
            System.out.println(deque.poll());
        }
    }
}
