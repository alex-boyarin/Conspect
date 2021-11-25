package Taski;

import java.util.ArrayList;
import java.util.List;

/**
 * Написать метод, который принимает целочисленный список и возвращает список
 * только с нечетными значениями.
 */
public class Task1 {
    public static void main(String[] args) {

        List<Integer> list = List.of(1, 3, 6, 8, 9, 13, 20);
        List<Integer> result = removeEven(list);
        System.out.println(result);
    }

    /**
     * 1-Array.asList и List.of возвращают нам только не изменяемые коллекции,
     * мы не можем добавлять или удалять из них.
     * 2-нельзя во время итерирования по коллекц. изменять ее.
     * 3-правило хорошего тона является то что нельзя изменять параметры метода.
     */
    private static List<Integer> removeEven(List<Integer> list) {
        List<Integer> result = new ArrayList<>();
        for (Integer value : list) {
            if (value % 2 != 0) {
                result.add(value);
            }
        }
        return result;
    }
}
