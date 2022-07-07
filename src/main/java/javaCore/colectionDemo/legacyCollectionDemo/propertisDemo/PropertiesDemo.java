package javaCore.colectionDemo.legacyCollectionDemo.propertisDemo;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/*
 * Утилитный класс Properties это так же один из контейнеров, который имеет очень широкое применение. Применяется как для хранения
 * инициализированных данных, например для установления соединения к базам данных. Применяется для локализации приложений.
 * Что собой представляет класс Properties- это типичный Мар у которого объектом хранения является пара(name, value)
 * и особенностью является очень удобное взаимодействие с файлами Properties, т.е. с файлами расширение у которых
 * .Properties Причем это единственные файлы которые легально могут лежать в папке src
 */
public class PropertiesDemo {
    public Properties loadFile(String filename) {
        Properties properties = new Properties();
        properties.put("key", "value");// можно добавить элемент методом put.
        try (InputStream inputStream = PropertiesDemo.class.getClassLoader().getResourceAsStream(filename)) {
            properties.load(inputStream);// Можно загрузить сразу файл.
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
}
