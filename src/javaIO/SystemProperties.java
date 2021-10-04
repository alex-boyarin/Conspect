package javaIO;

import java.util.Properties;

/*java с помощь класса System  проедоставляет возможность считать свойства которые переданы клиентом
 системные свойства виртуальной машины.
 Собственые свойства задаются так заходим в run_edit configuration  в графе VM options пишем -Dдалее без пробелов
 пишем имя и через равно value.*/
public class SystemProperties {
    public static void main(String[] args) {
        Properties properties = System.getProperties();
        properties.list(System.out);
    }
}
