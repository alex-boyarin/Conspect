package functionalPrograming.task;

import java.util.Map;

/*
 * Дана Map<String, Integer>. Найти сумму всех значений,
 * длинна ключей которых меньше 7 символов.
 */
public class Task3 {
    public static void main(String[] args) {
        Map<String, Integer> map = Map.of(
                "string1", 1,
                "strin2", 2,
                "string3", 3,
                "string4", 4,
                "strin5", 5
        );
        /*
         * Мы получили нашу Map<> и все что необходимо сделать это создать Stream  на основании
         * этой Map<>, мы помним что Map<> не является колекцией но она содержит внутри себя колекции
         * таким образом нам нужно оперировать как ключами так и значениями для того
         * чтобы решить нашу задачу, следовательно в в этом случае мы берем у Map<> метод entrySet()
         * и получаем множество элементов далее создаем поток stream() далее filter() фильтруем
         * по длине ключа далее преобразовываем к примитивному типу при помощи mapToInt()
         * в который передаем наши значения, и в конце вызываем sum(); в котором складываем значения
         * прошедшие фильтрацию по ключу.
         */
        int result = map.entrySet().stream()
                .filter(entry -> entry.getKey().length() < 7)
                .mapToInt(Map.Entry::getValue)
                .sum();
        System.out.println(result);
    }
}
