package javaIO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 * Пусть у нас есть некоторый файл, обьявляем файловую переменную, она ссылается на некоторый файл.
 * И пусть существует некоторый массив double. Попробуем этот массив даблов записать в файл. Обьявляем
 * PrintStream это поток для вывода в файл его нужно соединить с источником FileOutputStream
 * и в него отправляем наш file. Теперь организовываем цикл foreach,
 */
public class PrintStreamPrintWriterDemo {
    public static void main(String[] args) {
        File file = new File("data\\res.txt");
        double[] values = {1.10, 1.2, 1.401, 5.01, 6.017, 7, 8};
        try (PrintStream printStream = new PrintStream(new FileOutputStream(file))) {
            for (double value : values) {
                printStream.printf("java %.2g %n", value);
//если перенаправить поток таким образом, то вся информация запишется напрямую в файл.
                System.setOut(printStream);
                System.out.printf("%.2g %n", value);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
//        try (PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(file)))) {// PrintWriter оборачивается
//// потоком BufferedWriter
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
