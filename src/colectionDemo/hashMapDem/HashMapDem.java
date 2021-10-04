package colectionDemo.hashMapDem;

import colectionDemo.Person;

import java.util.HashMap;
import java.util.Map;

/* Map<> это интерфейс и у него есть
 несколько реализаций первая из них это HashMap
 */
public class HashMapDem {
    public static void main(String[] args) {
        Person ivan = new Person(1, "ivan", "Ivanov");
        Person petr = new Person(2, "petr", "petrov");
        Map<Integer, Person> map = new HashMap<>();
        map.put(ivan.getId(), ivan);// для добавления в таблицу какого либо значения мы используем map.put
        map.put(petr.getId(), petr);
        System.out.println(map.get(2));//для того чтобы получить значение по ключу.
        System.out.println(map.keySet());// вывод всех ключей.
        System.out.println(map.values());// получение всех значений.
        System.out.println(map.entrySet());//вывод всех ключей и значений.
        for (Person person : map.values()) {//можем проитерироваться по любым значениям Person
            System.out.println(person.getFirstName());
        }
        for (Map.Entry<Integer, Person> entry : map.entrySet()) {//тоже самое, мы можем получить
            //коллекцию ключ значение
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        /*Мар<> не поддерживает дублирование ключей, поэтому при создании обьекта с таким же
        ключом который уже имеется в коллекции, то он просто перезапишет собой существующий
         обьект*/
        Person sveta = new Person(1, "sveta", "svetikova");
        map.putIfAbsent(sveta.getId(), sveta);//putIfAbsent() метод проверяет перед добавлением
        //нового ключа есть он в коллкц. или нет. Если он уже есть то добавление не происходит
        for (Map.Entry<Integer, Person> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }//полезные методы для работы с Мар<>
        System.out.println(map.containsKey(2));//показывает есть ли в коллекции обьект с данным ключом(true, false)
        System.out.println(map.size());//определяет размер коллекции.
        System.out.println(map.isEmpty());//проверяет пустая или нет коллекц. Если пустая то True
        System.out.println(map.getOrDefault(4, sveta));//метод возвращает значение по ключу или указаное значение
        // (в скобках если ключа в коллекц. не существует.
    }
}
