package javaCore.colectionDemo.legacyCollectionDemo.propertisDemo;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class PropertiDemo {
    public static void main(String[] args) throws IOException {//src/main/resources/demo_all_file/
        PropertiesDemo propertiesDemo = new PropertiesDemo();
        Properties properties = propertiesDemo.loadFile("demo_all_file/data.properties");
        properties.list(System.out);// Чтобы вывести на консоль указываем такой метод.
        String key1 = properties.getProperty("p.0");
        String key2 = properties.getProperty("key.2");
        String key3 = properties.getProperty("key.0");

        String valueDefault = properties.getProperty("key4", "valueDefault");
        System.out.println(key1 + "\n" + key2 + "\n" + key3 + "\n" + valueDefault);

        //Сохраним объект Properties в том же самом файле.
        properties.store(new FileWriter("src/main/resources/demo_all_file/data.properties"), "etot method soxranit " +
                                                                                             "novie danie v fale.");

    }
}
/* Методы класса Properties
 * void list(PrintStream поток_вывода)-Направляет список свойств в поток вывода, с которым связан указанный поток_вывода.
 * void list(PrintWriter поток_вывода)-Направляет список свойств в поток вывода, с которым связан указанный поток_вывода.
 * void load(Reader reader)-Загружает свойства из файла, представленного объектом Reader
 * void load(InputStream inStream)-Загружает свойства из файла, представленного объектом InputStream
 * void loadFromXML(InputStream in)-Загружает свойства из XML-файла
 * Enumeration<?> propertyNames()-Возвращает перечисление ключей. В него включаются также ключи, находящиеся
 * в списке свойств по умолчанию.

 * Object get(Object key)-Возвращает значение по ключу. Метод унаследован от HashTable
 *
 * String getProperty(String key)-Возвращает значение свойства (строку) по ключу. Если же заданный ключ отсутствует
 * как в текущем списке, так и в списке свойств по умолчанию, то возвращается пустое значение null
 *
 * String getProperty(String key, String defaultValue)-Возвращает значение свойства по ключу или defaultValue, если такого ключа нет.
 *
 * Set<String> stringPropertyNames()-Возвращает список всех ключей
 * */
