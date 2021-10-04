package javaIO.bufferedReaderWriter_3;

import java.io.*;

/**
 * Буферизованые потоки. Для более удобного чтения, принято использовать не просто FileReader или
 * FileWriter а их буферизованые оболочки, которые позволяют читать строками и записывать строками.
 */
public class BufferedReaderWriterDemo {
    public static void main(String[] args) {
        // Так же используем try с ресурсами
        try (FileReader fileReader = new FileReader("data/in.txt");
//передаем в конструктор BufferedReader-а (fileReader)
             BufferedReader bufferedReader = new BufferedReader(fileReader);
// Создаем поток записи  FileWriter("data/write2.txt");
             FileWriter fileWriter = new FileWriter("data/write2.txt");
// Так же создаем BufferedWriter и передаем ему в конструктор (fileWriter)
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
// Создаем переменную типа String и присваиваем ей чтение первой строки.
            //  String line = bufferedReader.readLine();
// Здесь мы производим запись в файл прочитанной строки, указываем с какой позиции,
// и указываем длинну строки
            // bufferedWriter.write(line, 0, line.length());
            String line2 = null;
            while ((line2 = bufferedReader.readLine()) != null) {// Для чтения всех строк создаем цикл
                bufferedWriter.write(line2, 0, line2.length());
                bufferedWriter.newLine();// Для перехода на новую строку используем метод newLine()
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
