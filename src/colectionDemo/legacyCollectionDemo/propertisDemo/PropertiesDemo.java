package colectionDemo.legacyCollectionDemo.propertisDemo;

import java.util.Properties;

/*
 * Утилитный класс Properties это так же один из контейнеров, который имеет очень широкое применение. Применяется как для хранения
 * инициализацинных данных, например для установления соединения к базам данных. Применяется для локализации приложений.
 * Что собой представляет класс Properties- это типичный Мар у которого обьектом хранения является пара(name, value)
 * и особонностью является очень удобное взаимодействие с файлами Properties, т.е. с файлами расширение у которых .Properties
 * Причем это единственные файлы которые легально могут лежать в папке src
 */
public class PropertiesDemo {
    public Properties loadFile(String filename) {
        Properties properties = new Properties();
        properties.put("submit", "submit_A");// можно добавить элемент методом put.
//        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(filename);
//        try {
//            properties.load(inputStream);// Можно загрузить сразу файл.
//        } catch (IOException e) {
//            e.printStackTrace();
        return properties;
    }
}
