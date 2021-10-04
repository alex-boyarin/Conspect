package colectionDemo.queueDemo;

import java.util.LinkedList;
import java.util.Queue;

/* Очередь можно создать с помощью инициализации ее обьектом LinkedList<>()
Queue-это поведение первый зашел первый вышел.*/
public class QueueDemo {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>() {
            {//добавление с помощью анонимного класса.
                this.offer("jeans");//добавление элем. в конец очереди
            }
        };
        queue.add("Dress");
        queue.offer("T-Shirt");
        //queue.forEach(System.out::println);//цикл для вывода очереди
        //queue.remove();//удаление с начала очереди.
        //queue.remove("Dress");//Можно удалять и с середины очереди, но совпадение должно быть 100%
        //queue.forEach(System.out::println);
        //queue.clear();//очистка очереди.
        //queue.remove();// проверка генерирует ли метод exception
        //queue.element();//проверка генерирует ли метод exception
        queue.removeIf(s -> s.endsWith("t"));// С помощью этого метода можно удалить элем. заканчивающийся на определеное значение.
        queue.forEach(System.out::println);
        queue.add("T-shirt");
        queue.stream().filter(s -> !s.endsWith("t")).forEach(System.out::println);  // Сделаем теже действия с помощью Stream-поток.
        // Поток удобен тем что он не меняет очередь, и при выводе исходного списка, он будет полной. А Стандартные методы меняют
        //очередь.
        queue.forEach(System.out::println);
    }
}
