package colectionDemo.linkedHashMapDemo;

import colectionDemo.Person;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * LinkedHashMap Используется для сохранения порядка коллекции в таком виде в котором она была
 * создана, без сортировки и перемешивания.
 */
public class LinkedHashMapDemo {
    public static void main(String[] args) {
        Person ivan = new Person(4, "ivan", "Ivanov");
        Person petr = new Person(29, "petr", "petrov");
        Person sveta = new Person(3, "sveta", "svetikova");
        Map<Integer, Person> map = new LinkedHashMap<>();
        map.put(ivan.getId(), ivan);
        map.put(petr.getId(), petr);
        map.putIfAbsent(sveta.getId(), sveta);
        for (Map.Entry<Integer, Person> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
