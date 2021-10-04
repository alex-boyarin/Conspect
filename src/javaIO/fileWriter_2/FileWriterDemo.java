package javaIO.fileWriter_2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Начиная с java_2 были включены символьные потоки как чтения так и записи.
 * try с ресурсами- это значит что мы сразу после try открываем круглые скобки
 * и внутри создаем (обьявление) поток. Для блока try с ресурсами не требуется закрытие потока.
 */
public class FileWriterDemo {
    public static void main(String[] args) {
        try (FileReader fileReader = new FileReader("data/in.txt");
             // Чтобы файл дозаписывался нужно добавить в конструктор true.
             FileWriter fileWriter = new FileWriter("data/write.txt", true)) {
            fileWriter.write("java");// добавился метод с параметрами String
            int symbol = fileReader.read();
            // мы знаем что считался код символа, но этот метод превратит его в символ
            fileWriter.write(symbol);
            char[] buffer = new char[20];
            int num = fileReader.read(buffer);
            while (num != -1) {
                fileWriter.write(buffer, 0, num);
                // buffer- это массив в который было произведено чтение,
                // 0-это с какой позиции начинать запись, num-это количество символов,
                // в данном случае весь массив.
                num = fileReader.read(buffer);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
