package javaCore.colectionDemo.legacyCollectionDemo.propertisDemo;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class PropertiDemo {
    public static void main(String[] args) throws IOException {
        PropertiesDemo propertiesDemo = new PropertiesDemo();
        Properties properties = propertiesDemo.loadFile("src/main/resources/demo_all_file/data.properties");
        properties.list(System.out);// Чтобы вывести на консоль указываем такой метод.
        String key1 = properties.getProperty("key1");
        String key2 = properties.getProperty("key2");
        String valueDefault = properties.getProperty("key3", "valueDefault");
        System.out.println(key1 + "\n" + key2 + "\n" + valueDefault);

        //Сохраним объект Properties в том же самом файле.
        properties.store(new FileWriter("src/main/resources/demo_all_file/data.properties"), "Comment prop");

    }
}
/* Методы класса Properties
 * void load(Reader reader)-Загружает свойства из файла, представленного объектом Reader
 * void load(InputStream inStream)-Загружает свойства из файла, представленного объектом InputStream
 * void loadFromXML(InputStream in)-Загружает свойства из XML-файла
 * Object get(Object key)-Возвращает значение по ключу. Метод унаследован от HashTable
 * String getProperty(String key)-Возвращает значение свойства (строку) по ключу
 * String getProperty(String key, String defaultValue)-Возвращает значение свойства по ключу или defaultValue, если такого ключа нет
 * Set<String> stringPropertyNames()-Возвращает список всех ключей*/