package colectionDemo.hashSetLinkedSetTreeSetDemo;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/*
 * У Set нету метода sort, и так же при вызове Collections.sort() мы не можем передать
 * в него Set. И так как Set настолько отличается от List мы не можем получить значение по индексу
 * т.е. у нас нет метода get. И все что мы можем сделать это только пройтись итератором
 * по колекции и посмотреть какие есть значения set.forEach
 */
public class hashSetLinkedSetTreeSetDemo {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();//Наиболее используемая реализация Set-а
        // позволяет избежать дубликации данных. HashSet не сохраняет порядок добавления.
        set.add("h");
        set.add("b");
        set.add("kс");
        set.add("d");
        set.add("h");
        System.out.println(set);
        //Если нам нужен такой же порядок как при добавлении то тогда нужно использовать
        //LinkedHashSet<>
        Set<String> linkedSet = new LinkedHashSet<>();
        linkedSet.add("h");
        linkedSet.add("b");
        linkedSet.add("kс");
        linkedSet.add("d");
        linkedSet.add("h");
        System.out.println(linkedSet);
        //Если нам нужно чтобы элементы распологались в порядке возрастания то нужно
        //использовать реализацию TreeSet<>
        Set<String> treeSet = new TreeSet<>();
        treeSet.add("h");
        treeSet.add("b");
        treeSet.add("kс");
        treeSet.add("d");
        treeSet.add("h");
        System.out.println(treeSet);
//        System.out.println( set.add("a"));
//        System.out.println(set.add("b"));
//        System.out.println(set.add("cс"));
//        System.out.println(set.add("d"));
//        System.out.println(set.add("a"));
    }
}
