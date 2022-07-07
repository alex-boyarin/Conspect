package javaCore.colectionDemo.hashMapDem;

import java.util.*;

/* Интерфейс MAP представляет собой описание пары ключ значение, где ключ всегда уникален.
И область применение подобного интерфейса и классов которые реализуют этот интерфейс весьма обширны. */
public class MapDemo {
    public static void main(String[] args) {
        // Создавать объект класса МАР нельзя т.к. это интерфейс, поэтому инициализируем HashMap.
        Map<String, Integer> map = new HashMap<>();
        map.put("Hut", 1);// put- добавляет
        map.put("Jeans", 2);
        map.put("Gloves", 3);
        System.out.println(map + " map исходная");
        System.out.println("получаем значение Jeans = " + map.get("Jeans"));
        /* При попытке добавление с тем же самым ключом, но с разным значением. У метода put есть особенность
        при замене элемента, возвращаемое значение будет значение которое было заменено т.е. он вернет "5" */
        int value = map.put("Jeans", 10);// Если ключ уже существует, то произойдет замена на новое значение.

        System.out.println("Выводится старое значение =  " + value);// Выводится старое значение.
        System.out.println(map + " map с новым значением Jeans");

        // Можно получить множество ключей.
        Set<String> set = map.keySet();
        System.out.println(set + " получаем множество ключей");

        // можно вывести множество значений.
        Collection<Integer> collection = map.values();
        System.out.println(collection + " получаем множество значений.");

        // такими действиями можно получить коллекцию даже из одного элемента,
        // если значения у всех элементов были одинаковые.
        Set<Integer> sets = new HashSet<>(collection);
        System.out.println(sets+" получаем сортированную коллекцию значений");

        Set<Map.Entry<String, Integer>> values = map.entrySet();
        System.out.println(values);
    }
}
