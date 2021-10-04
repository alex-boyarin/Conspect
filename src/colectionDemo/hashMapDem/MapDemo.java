package colectionDemo.hashMapDem;

import java.util.*;

/* Интерфейс MAP представляет собой описание  пары ключ значение, где ключ всегда уникален. И область применение подобного интерфейса
и классов которые реализуют этот интерфейс весьма обширны.
 */
public class MapDemo {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();// Создавать обьект класса МАР нельзя т.к. это интерфейс, поэтому инициализируем HashMap.
        map.put("T-Shirt", 5);// put- добавляет
        map.put("Jeans", 5);
        map.put("Gloves", 5);
        //System.out.println(map);

        System.out.println(map.get("Jeans"));
        /* При попытке добавление с тем же самым ключом, но с разным значением. У метода put есть особенность
        при замене элемента, возвращаемое значение будет значение которое было заменено т.е. он вернет "4"
         */
        // int value = map.put("Jeans", 2);
        // System.out.println(value);// выводится старое значение.
        System.out.println(map);
        Set<String> set = map.keySet();// Можно получить множество ключей.
        System.out.println(set);
        Collection<Integer> collection = map.values();// можно вывести множество значений.
        System.out.println(collection);
        Set<Integer> sets = new HashSet<>(collection);// такими действиями можно получить коллекцию из одного элемента, если
        //значения у всех элементов были одинаковые.
        System.out.println(sets);
        Set<Map.Entry<String, Integer>> values = map.entrySet();
        System.out.println(values);
    }
}
