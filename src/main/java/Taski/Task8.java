package Taski;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.CREATE;

/**
 * Задан файл с java-кодом. Прочитать текст программы из файла
 * и записать в другой файл в обратном порядке символы
 * каждой строки.
 */
public class Task8 {
    public static void main(String[] args) {
        Path path = Path.of("src", "Tasks", "Task7.java");
        Path result = Path.of("resources", "Task7.java");
        /* Файл будем считывать построчно и заменять, для этого будем использовать стримы */
        try (Stream<String> lines = Files.lines(path);
             /* Создаем newBufferedWriter() вставляем путь к файлу в который будем записывать
             далее нам нужны OpenOption...options которые говорят нам о том что мы хотим добавлять
             в конец нашего файла а не перезаписывать его. Таким образом StandardOpenOption.APPEND
              */
             BufferedWriter bufferedWriter = Files.newBufferedWriter(result, APPEND, CREATE)) {
            lines.map(StringBuilder::new).map(StringBuilder::reverse)
                    .forEach(line -> {
                        try {
                            bufferedWriter.write(line.toString());
                            bufferedWriter.newLine();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
