package javaCore.functionalPrograming.task;

import java.util.List;
import java.util.stream.Collectors;

/*
 * Дан Список строк. Найти количество уникальных строк длиной более 8 символов.
 */
public class Task2 {
    public static void main(String[] args) {
        List<String> strings = List.of(
                "string11",
                "string22",
                "string33",
                "string44",
                "string111",
                "string111",
                "string111",
                "string222",
                "string444"
        );
        /*
         * Первое преобразуем нашу строку в stream() далее вызываем filter(задаем условие)
         * далее методом collect(Collectors.toSet()) преобразовываем в колекцию уникальных элементов
         * и потом вызвать метод size() и мы получим размер который мы ожидаем
         */
        int result = strings.stream()
                .filter(value -> value.length() > 8)
                .collect(Collectors.toSet())//можно преобразовать в другую коллекцию
                .size();
        System.out.println(result);
        /*
         * Можно поступить и другим способом. Для этого после метода filter() мы вызываем метод distinct()
         * который уберает все дубликаты и после этого мы вызываем метод count() который посчитает кол-во
         * элем в нашем stream()
         */
        long result2 = strings.stream()
                .filter(value -> value.length() > 8)
                .distinct()
                .count();
        System.out.println(result2);
    }
}
