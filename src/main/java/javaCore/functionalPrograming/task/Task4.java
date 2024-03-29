package javaCore.functionalPrograming.task;

import java.util.List;
import java.util.stream.Collectors;

/*
 * Да список целых чисел, вывести строку представляющую собой
 * конкатенацию строковых представлений этих чисел.
 * Пример: список {5, 2, 4, 2, 1 } результат строка: "52421"
 */
public class Task4 {
    public static void main(String[] args) {
        List<Integer> integers = List.of(5, 2, 4, 2, 1);
        String result = integers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());
        System.out.println(result);
    }
}
