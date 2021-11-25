package javaCore.io_ot_DMDEV;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

/**
 * С помощью класса Files можно сократить код  для записи в файл. У этого класса есть
 * все методы от других классов для записи и чтения данных, а так же много новых.
 * Для его реализации не требуется создавать обьект типа File. Теперь это место занимает класс
 * Path. Класс Files  внутри себя реализует все необходимые операции, а так же
 * try с реурсами
 */
public class FilesClassRunner {
    public static void main(String[] args) throws IOException {
        Path path = Path.of("car");
        Files.write(path, List.of("hello world!", "java.")); // Также мы можем использовать этот класс и для записи в файл

        Path path1 = Path.of("car");
        try (Stream<String> stringStream = Files.lines(path1)) {
            stringStream.forEach(System.out::println);
        }
    }
}
