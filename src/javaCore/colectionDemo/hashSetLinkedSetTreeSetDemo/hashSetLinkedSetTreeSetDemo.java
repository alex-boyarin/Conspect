package javaCore.colectionDemo.hashSetLinkedSetTreeSetDemo;

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
        //Если нам нужен такой же порядок как при добавлении, то тогда нужно использовать
        //LinkedHashSet<>
        Set<String> linkedSet = new LinkedHashSet<>();
        linkedSet.add("h");
        linkedSet.add("b");
        linkedSet.add("kс");
        linkedSet.add("d");
        linkedSet.add("h");
        System.out.println(linkedSet);
        //Если нам нужно чтобы элементы располагались в порядке возрастания, то нужно
        //использовать реализацию TreeSet<>
        Set<String> treeSet = new TreeSet<>();
        treeSet.add("ha");
        treeSet.add("aab");
        treeSet.add("kaAс");
        treeSet.add("da");
        treeSet.add("h");
        System.out.println(treeSet);
        System.out.println(set.add("a"));//если элемента в колекц. нет то он добавиться и вернет true
        System.out.println(set.add("b"));//если элемент уже есть то он не добавится и вернет false
        System.out.println(set.add("cс"));
        System.out.println(set.add("d"));
        System.out.println(set.add("a"));
    }
}
