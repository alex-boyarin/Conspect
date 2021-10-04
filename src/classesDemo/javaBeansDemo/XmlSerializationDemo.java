package classesDemo.javaBeansDemo;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;

/**
 * Сериализация в XML файл.
 * Создаем XMLEncoder ему нужен буферизованый поток BufferedOutputStream и FileOutputStream
 * с указаным местом сохранения. Далее создаем обьект который хотим сохранить,
 * и действие по сохраняемости очень простое, вызывается метод writeObject() и передаем ему
 * обьек котрый мы создали. И выполним для подобного потока стандартное действие flush.
 * flush()-Очищает этот выходной поток и заставляет записывать все буферизованные выходные байты.
 * Общий контракт сброса заключается в том, что его вызов указывает на то, что,
 * если какие-либо ранее записанные байты были буферизованы реализацией выходного потока,
 * такие байты должны быть немедленно записаны в их предполагаемое место назначения.
 * Если предполагаемое место назначения этого потока является абстракцией,
 * предоставляемой базовой операционной системой, например файлом,
 * то очистка потока гарантирует только то, что байты, ранее записанные в поток,
 * передаются операционной системе для записи; это не гарантирует,
 * что они действительно записаны на физическое устройство, такое как дисковый накопитель.
 */
public class XmlSerializationDemo {
    public static void main(String[] args) {
        try (XMLEncoder xmlEncoder = new XMLEncoder(new BufferedOutputStream
                (new FileOutputStream("data/serial.xml")))) {
            JavaBeanDemo javaBeanDemo = new JavaBeanDemo(250986, 36.6);
            xmlEncoder.writeObject(javaBeanDemo);
            xmlEncoder.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        // В этой части программы мы обртно декодируем xml файл
        try (XMLDecoder xmlDecoder = new XMLDecoder(new BufferedInputStream
                (new FileInputStream("data/serial.xml")))) {
            // т.к. метод readObject() возвращает обьект типа Object, нам нужно преобразовать его
            // к нашему обьекту (JavaBeanDemo)
            JavaBeanDemo javaBeanDemo = (JavaBeanDemo) xmlDecoder.readObject();
            System.out.println(javaBeanDemo);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
