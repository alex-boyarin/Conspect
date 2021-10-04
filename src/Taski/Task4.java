package Taski;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

/**
 * Задан файл с текстом, найти и вывести в консоль все слова,
 * начинающиеся с гласной.
 */
public class Task4 {
    private static final String VOWELS = "уеыаоэюяи";

    public static void main(String[] args) throws IOException {
        Path path = Path.of("resources", "test.txt");
        try (Scanner scanner = new Scanner(path)) {/*Чтобы корректно работать с любыми потоком ввода вывода
            мы обязаны его оборачивать в try c ресурсами, чтобы закрывать потоки. Scanner хоть и не относится
            к потокам ввода вывода, но он реализует интерфейс Closeable */
            while (scanner.hasNext()) { /* В цикле проверяем есть ли следующие слово в нашем файле,вызываем метод
            hasNext()  */
                String word = scanner.next();
                char firstSymbol = word.charAt(0);//charAt()-метод который берет из слова по заданному
                //номеру символ.
                if (VOWELS.indexOf(firstSymbol) != -1) {// проверяем содержит ли наша строка какой либо символ из указанных
                    System.out.println(word);
                }
            }
        }
    }
}
