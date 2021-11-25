package javaCore.javaIO.serializationDemo;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * Действие по десириализации выполняется с помощью класса ObjectInputStream
 * и его метода readObject().
 */
public class DeserializationDemo {
    public static void main(String[] args) {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("data/out.dat"))) {
            Student student = (Student) objectInputStream.readObject();
            System.out.println(student);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
