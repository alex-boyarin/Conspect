package javaCore.functionalPrograming;

import java.util.List;

public class StreamExample {
    public static void main(String[] args) {
        List<String> strings = List.of("88", "11", "22", "33", "44", "55", "66");
        /** До того как у нас появились Stream мы просто итерировались по нашей коллекции
         * использовав цикл foreach, и мог делать какое-то действие с нашим элементом */
        /*примеp*/
//        for (String string : strings) {
//            String value = string + string;
//            Integer intValue = Integer.valueOf(value);//преобразуем  value в  Integer
//            if (intValue % 2 == 0) {
//                System.out.println(intValue);
//            }
//        }
        /*теперь будем использовать метод stream, который преобразует эту коллекцию в поток.
        теперь у нас есть возможность обрабатывать каждый из этих элементов коллекц. по отдельности*/
        strings.stream()
                .map(string -> string + string)//т.к.нам уже известен тип параметра то мы его
                // не пишем и называть переменные можем как угодно.
                .map(Integer::valueOf)//здесь мы преобразовываем string в Integer
                .filter((Integer value) -> value % 2 == 0)//здесь мы вызываем filter и передаем ему
                //наш Integer value с условием.
                .sorted()/*мы можем отсортировать элементы, которые пришли после фильтрации
                раз это Integer то при вызове метода без параметров мы будем использовать
                интерфейс Comparable. Если же наши элементы не реализуют интерфейс Comparable
                следовательно мы не можем использовать сортировку по умолчанию и обязаны передать
                 интерфейс Comparator*/
                .skip(1)//-пропускать//этот метод пропускает указанное кол-во элементов
                .limit(2)//этот метод ограничивает кол-во переданых элементов
                .forEach(System.out::println);//если мы вызываем терминальный оператор forEach
        // то stream() прекращает свою работу
    }
}
