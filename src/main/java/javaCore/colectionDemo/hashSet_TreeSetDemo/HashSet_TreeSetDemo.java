package javaCore.colectionDemo.hashSet_TreeSetDemo;

import java.util.HashSet;
import java.util.TreeSet;


public class HashSet_TreeSetDemo {
    public static void main(String[] args) {
        /*Performance-производительность у HashSet выше (Performance HashSet is faster) В HashSet можно добавлять null.
          (HashSet allows(позволяет) null object) HashSet использует equals() для сравнения при добавлении объектов но
          equals всегда должен быть переопределен в паре с HashCode. HashSet не упорядоченное множество */
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("h1");
        hashSet.add("h1");//дубликаты не допускаются
        hashSet.add("z2");
        hashSet.add("y3");
        hashSet.add("x4");
        hashSet.add("w5");
        hashSet.add("v6");
        hashSet.add("a7");
        hashSet.add("t8");
        hashSet.add("s9");
        hashSet.add("r0");
        hashSet.add("1q");
        hashSet.add("2p");
        hashSet.add("3o");
        System.out.println(hashSet + " hashSet");
        for (String element : hashSet) {
            System.out.print(element.hashCode() + ", ");
        }
        System.out.println("");

        /* TreeSet использует метод для сравнения compareTo. TreeSet -это упорядоченное множество,
           TreeSet более экономный с точки зрения использования памяти.*/
        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.add("h1");
        treeSet.add("h1");//дубликаты не допускаются
        treeSet.add("z2");
        treeSet.add("y3");
        treeSet.add("x4");
        treeSet.add("w5");
        treeSet.add("v6");
        treeSet.add("a7");
        treeSet.add("t8");
        treeSet.add("s9");
        treeSet.add("r0");
        treeSet.add("1q");
        treeSet.add("2p");
        treeSet.add("3o");
        System.out.println(treeSet + " treeSet");
        for (String s : treeSet) {
            System.out.print(s.hashCode() + ", ");
        }

    }
}
