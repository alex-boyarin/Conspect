package javaIO;

import java.io.*;
import java.util.ArrayList;

/**
 * В java 8 появился новый метод у класса BufferReader, который дает возможность
 * считать весь файл целиком и отправить его в поток, не нужно строить сложных
 * конструкций, а действие теперь по чтению всей информации станивиться весьма простым.
 */
public class BufferReaderDemo {
    public static void main(String[] args) {
        try (FileReader fileReader = new FileReader("data/in.txt");
             BufferedReader bufferedReader = new BufferedReader(fileReader);
             FileWriter fileWriter = new FileWriter("data/write3");
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            // При помощи BufferedReader и метода lines() можно сразу прочитать и вывести весь файл.
            // bufferedReader.lines().forEach(System.out::println);
            ArrayList<String> strings = new ArrayList<>();// можно записать в список.
            bufferedReader.lines().forEach(strings::add);
            System.out.println(strings);
            for (String string : strings) {
                bufferedWriter.write(string);
                bufferedWriter.newLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
