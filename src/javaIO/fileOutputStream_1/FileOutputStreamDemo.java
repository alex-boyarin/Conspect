package javaIO.fileOutputStream_1;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Самый древний байтовый поток вывода в файл.
 */
public class FileOutputStreamDemo {
    public static void main(String[] args) {
/** try с ресурсами-это значит что мы сразу после try открываем круглые скобки
 * и внутри создаем (обьявление) поток. Для блока try с ресурсами не требуется закрытие потока.
 */
        try (FileOutputStream fileOutputStream = new FileOutputStream("data/out.txt", true)) {
            fileOutputStream.write(53);// Можем записать просто целое число-это будет код символа
            byte[] array = {122, 99, 66, 78, 56};// Можно записать массив байт
            fileOutputStream.write(array);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        /**Т.к. эта конструкция закрытия чтения из файла используется очень часто,
         * и она громоздка, то было решено ввести понятие Try с ресурсами, для этого обьявление
         * FileOutputStream было перенесено в параметры Try.
         * А от блока finally было решено избавиться. Поэтому он закоментирован.
         */
//             finally {
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
