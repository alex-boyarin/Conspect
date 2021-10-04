package colectionDemo.hashSetVsTreeSetDemo;

import java.util.HashSet;
import java.util.TreeSet;

/* Performance-производительность у HashSet выше (Performance.HashSet is faster)
В HashSet можно добавлять null.   (HashSet allows(позволяет) null object)
HashSet использует equals() для сравнениния придобавлении обьектов но equals всегда должен быть переопределен в паре с
HashCode, TreeSet использует метод для сравнения compareTo. TreeSet -это упорядоченое множество,
HashSet не упорядоченое. TreeSet более экономный с точки зрения использования памяти.*/
public class HashSetVsTreeSetDemo {
    public static void main(String[] args) {
        HashSet<String> words = new HashSet<>(1000);
        words.add("8y1");
        words.add("2y");
        words.add("2y2");
        words.add("8y1");
        words.add("6y");
        words.add("5z");
        words.add("4y4");
        System.out.println(words);
        for (String element : words) {
            System.out.print(element.hashCode() + " ");
        }
        System.out.println("");
        TreeSet<String> treeSet = new TreeSet<>(words);
        System.out.println(treeSet);

    }
}
