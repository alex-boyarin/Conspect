package javaIO.serializationDemo;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Сериализация является неотьемлемой частью javabean , сериализация включает в себя возможности сохранения обьекта целиком.
 * Требования: класс должен быть public, у класса должен быть public конструктор поумолчанию, у класса должны быть
 * поля инкапсулированые, и у класса должны быть коректные get- set-.
 * Чтобы сериализ. была возможной, класс должен implements (interface) Serializable.
 * Ключевое слово transient -временный, ставится перед нестатическими полями, поле перед которым стоит transient не будет
 * сериализованно т.е. не будет сохранено в потоке. При десериализации значение этого поля будет присвоено по умолчанию
 * для типа этого поля. (int-0, String-"null", для всех обьектных типов это "null").
 * <p>
 * Сиреализация выполняется просто, необходимо создать поток ObjectOutputStream
 * соеденить его с точкой куда передается обьект и выполнить метод writeObject().
 * <p>
 * Обратное действие по десириализации выполняется с помощью класса ObjectInputStream
 * и его метода readObject().
 */
public class SerializationDemo {
    public static void main(String[] args) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream("data/out.dat"))) {
            Student student = new Student("Grisha", 123456, "qwerty");
            objectOutputStream.writeObject(student);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
