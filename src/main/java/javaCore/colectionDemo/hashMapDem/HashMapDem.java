package javaCore.colectionDemo.hashMapDem;

import java.util.HashMap;
import java.util.Map;

/* Map<> это интерфейс и у него есть несколько реализаций.  */
public class HashMapDem {
    public static void main(String[] args) {
        Person ivan = new Person(1, "ivan", "ivanov");
        Person petr = new Person(2, "petr", "petrov");
        Person sasha = new Person(3, "sasha", "sashkavich");
        Person pit = new Person(4, "pit", "pitkovich");

        /* Первая реализация из них это HashMap */
        Map<Integer, Person> map = new HashMap<>();
        // для добавления в таблицу какого либо значения мы используем map.put
        map.put(ivan.getId(), ivan);
        map.put(petr.getId(), petr);
        map.put(sasha.getId(), sasha);
        map.put(pit.getId(), pit);

        System.out.println("получить значение по ключу- " + map.get(2));//для того чтобы получить значение по ключу.
        System.out.println("вывод всех ключей.- " + map.keySet());// вывод всех ключей.
        System.out.println("получение всех значений.- " + map.values());// получение всех значений.
        System.out.println("вывод всех ключей и значений.- " + map.entrySet());//вывод всех ключей и значений.

        //можем проитерироваться по любым значениям Person.
        for (Person person : map.values()) {
            System.out.println(person.getFirstName());
        }
        //то же самое, мы можем получить коллекцию ключ значение.
        for (Map.Entry<Integer, Person> entry : map.entrySet()) {
            System.out.print(entry.getKey() + " " + entry.getValue());
        }
        /* Мар<> не поддерживает дублирование ключей, поэтому при создании объекта с таким же
        ключом который уже имеется в коллекции, то он просто перезапишет собой существующий объект */
        Person sveta = new Person(1, "sveta", "svetikova");

        //putIfAbsent() метод проверяет перед добавлением нового ключа есть он в коллкц. или нет.
        // Если он уже есть то добавление не происходит
        map.putIfAbsent(sveta.getId(), sveta);//эта запись добавлена не будет т.к. метод putIfAbsent
        // не позволяет добавлять дубликаты
        for (Map.Entry<Integer, Person> entry : map.entrySet()) {
            System.out.print(entry.getKey() + " " + entry.getValue());
        }
        //полезные методы для работы с Мар<>
        //показывает есть ли в коллекции объект с данным ключом(true, false)
        System.out.println("показывает есть ли в коллекции объект с данным ключом(true, false)- " + map.containsKey(2));
        //определяет размер коллекции.
        System.out.println("определяет размер коллекции.- " + map.size());
        //Проверяет пустая или нет коллекц. Если пустая то True.
        System.out.println("Проверяет пустая или нет коллекц. Если пустая то True- " + map.isEmpty());
        //метод возвращает значение по ключу или указанное значение в скобках, если ключа в коллекц. не существует.
        System.out.println("метод возвращает значение по ключу или указанное значение в скобках, " +
                           "если ключа в коллекц. не существует.- " + map.getOrDefault(4, ivan));
    }
}
