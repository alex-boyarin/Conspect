package javaCore.io_ot_DMDEV;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;

public class InputStreamRunner {
    public static void main(String[] args) throws IOException {
        /** File file = new File(String.join(File.separator, "javaCore.resources", "test.txt"));
         * т.к. приходилось очень часто делать такую конструкцию, то создался новый класс Path
         * он появился с созданием не блокирующего ввода вывода java.nio.file
         * Поэтому мы можем им воспользоваться для того чтобы создать файл.
         * И все что нам нужно сделать это вызвать статический метод of() и передать туда String
         * путь к нашему файлу где мы перечисляем через запятую наши директории файлы.
         * Таким образом мы получаем обьект Path.
         */
        File file = Path.of("resources", "test.txt").toFile();
        try (FileInputStream inputStream = new FileInputStream(file)) {
//            byte[] bytes = inputStream.readAllBytes();//метод который считывает все байты нам.
//            String stringValue = new String(bytes);
//            System.out.println(stringValue);
            //этим методом мы пользуемся если нам нужно скачать сразу весь файл
            //Если нам необходимо считывать понемножку наш файл, то сделаем это с помощью метода read()
            byte[] bytes = new byte[inputStream.available()];//мы создаем массив определенного размера
            //для этого мы знаем что у нашего inputStream есть метод available() который возвращает кол-во
            //доступных байт у нашего файла. Далее мы создадим счетчик наших байт и текущий байт который мы считываем
            int counter = 0;
            byte currentByte;//-current-текущий
            while ((currentByte = (byte) inputStream.read()) != -1) { //в цикле мы вызываем наш метод read() и считываем по байтно то что мы хотим
                // и пока наш байт не равен -1 следовательно этот байт содержит полезную инфу
                bytes[counter++] = currentByte;
            }
            String stringValue = new String(bytes);
            System.out.println(stringValue);
        }
    }
}
