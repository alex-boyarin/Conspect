package functionalPrograming.task;

import java.util.List;
import java.util.OptionalDouble;

/*
 * Дан список целых чисел. Найти среднее всех нечетных чисел,
 * делящихся на 5.
 */
public class Task1 {
    public static void main(String[] args) {
        List<Integer> integers = List.of(1, 5, 10, 15, 25, 20, 35, 12);
        OptionalDouble optionalDouble = integers.stream()
                .filter(value -> value % 2 != 0)
                .filter(value -> value % 5 == 0)
                .mapToInt(Integer::intValue)
                .average();
        optionalDouble.ifPresent(System.out::println);
    }
}
