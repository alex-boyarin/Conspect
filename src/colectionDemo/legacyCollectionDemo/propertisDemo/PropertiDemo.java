package colectionDemo.legacyCollectionDemo.propertisDemo;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class PropertiDemo {
    public static void main(String[] args) throws IOException {
        PropertiesDemo propertiesDemo = new PropertiesDemo();
        Properties properties = propertiesDemo.loadFile("data/aaa.properties");
        properties.list(System.out);// Чтобы вывести на консоль указываем такой метод.
        String label = properties.getProperty("label");
        String value = properties.getProperty("abc");
        String valueDefault = properties.getProperty("xyz", "y-");
        System.out.println(value + " " + valueDefault);
        properties.store(new FileWriter("data/message.properties"), "Comment prop");//Сохраним обьект  Properties в том же самом файле.

    }
}
