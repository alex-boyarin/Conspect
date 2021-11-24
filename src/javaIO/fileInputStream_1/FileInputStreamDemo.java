package javaIO.fileInputStream_1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

/*Самый древний поток ввода вывода для чтения из файла байтовых значений.*/
public class FileInputStreamDemo {
    public static void main(String[] args) {
        FileInputStream input = null;
        try {
            input = new FileInputStream("in");
            int code = input.read();
            System.out.println(code + " = " + (char) code);
            byte[] array = new byte[10];
            int code1 = input.read(array);//кол-во прочитанных байт
            System.out.println(code1);
            System.out.println(Arrays.toString(array));// массив байт
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {    // Потоки обязательно закрывают!!!
            try {
                if (input != null) {
                    input.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
