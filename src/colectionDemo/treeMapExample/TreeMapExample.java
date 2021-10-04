package colectionDemo.treeMapExample;

import colectionDemo.Person;

import java.util.Map;
import java.util.TreeMap;

/*
 * сортирует коллекцию по ключу
 */
public class TreeMapExample {
    public static void main(String[] args) {
        Person ivan = new Person(4, "ivan", "Ivanov");
        Person petr = new Person(29, "petr", "petrov");
        Person sveta = new Person(3, "sveta", "svetikova");
        Person sveta1 = new Person(30, "sveta1", "svetikova1");
        Person sveta2 = new Person(45, "sveta2", "svetikova2");
        Person sveta3 = new Person(10, "sveta3", "svetikova3");
        Map<Integer, Person> map = new TreeMap<>();// сортирует колекцию по ключу
        map.put(ivan.getId(), ivan);
        map.put(petr.getId(), petr);
        map.putIfAbsent(sveta.getId(), sveta);
        map.putIfAbsent(sveta1.getId(), sveta1);
        map.putIfAbsent(sveta2.getId(), sveta2);
        map.putIfAbsent(sveta3.getId(), sveta3);
        for (Map.Entry<Integer, Person> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
