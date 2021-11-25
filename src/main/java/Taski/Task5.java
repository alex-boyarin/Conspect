package Taski;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

/**
 * Задан файл с текстом, найти и вывести в консоль все слова,
 * для которых последняя буква одного слова совпадает с первой буквой следующего слова.
 */
public class Task5 {
    public static void main(String[] args) throws IOException {
        Path path = Path.of("resources", "test.txt");
        try (Scanner scanner = new Scanner(path)) {
            String previous = null;//previous-предыдущий
            if (scanner.hasNext()) {
                previous = scanner.next();
            }
            while (scanner.hasNext()) {
                String current = scanner.next();//current- текущий
                if (isEqualLastSymbolAndFirstSymbol(previous, current)) {
                    System.out.println(previous + "-" + current);
                }
                previous = current;
            }
        }
    }

    /*
    Создаем метод для сравнения нужных нам элементов, в метод передаем предыдущее слов и следующие
    за ним. В Метод charAt(previous.length() - 1) передаем длинну слова и отнимаем 1,
    т.к. массив считается с "0". После этого сравниваем на == с следующим словом,
    у него так же вызываем метод charAt(0) и указываем нулевой символ, т.к. нам нужна первая буква слова
     */
    public static boolean isEqualLastSymbolAndFirstSymbol(String previous, String current) {
        return previous.charAt(previous.length() - 1) == current.charAt(0);
    }
}
