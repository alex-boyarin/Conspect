package Taski;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Задан файл с java-кодом. Прочитать текст программы из файла и все слова public
 * в обьявлении атрибутов и методов заменить на слово privat.
 * Результат сохранить в другой заранее созданный файл.
 */
public class Task7 {
    public static void main(String[] args) {
        Path path = Path.of("src", "Tasks", "Task6.java");//указываем путь к файлу java
        try {
            String stringValue = Files.readString(path);
            String result = stringValue.replace("public", "private");
            Path resultPath = Path.of("resources", "Task6.java");
            Files.writeString(resultPath, result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
