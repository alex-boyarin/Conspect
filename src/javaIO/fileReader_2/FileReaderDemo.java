package javaIO.fileReader_2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

/**
 * Начиная с java_2 были включены символьные потоки как чтения так и записи.
 * try с ресурсами- это значит что мы сразу после try открываем круглые скобки
 * и внутри создаем (обьявление) поток. Для блока try с ресурсами не требуется закрытие потока.
 */
public class FileReaderDemo {
    public static void main(String[] args) {
        try (FileReader fileReader = new FileReader("data/in.txt")) {
            //метод чтение одного символа (возвращено будет кодовое обозначение)
            int symbol = fileReader.read();
            System.out.println(symbol);
            // C помощью массива char[] мы читаем реальные символы а не кодовое обозначение.
            char[] buffer = new char[5];
            fileReader.read(buffer);
            System.out.println(Arrays.toString(buffer) + "\n");
            char[] buffer2 = new char[5];
            fileReader.skip(2);// с помощью этого метода можно пропустить часть байтов.
            fileReader.read(buffer2);
            System.out.println(Arrays.toString(buffer2));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        /**Т.к. эта конструкция закрытия чтения из файла используется очень часто,
         * и она громоздка, то было решено ввести понятие Try с ресурсами, для этого обьявление
         * FileReader было перенесено в параметры Try.
         * А от блока finally было решено избавиться. Поэтому он закоментирован.
         */
//        finally {
//            try {
//                if (fileReader != null) {
//                    fileReader.close();
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
    }
}
