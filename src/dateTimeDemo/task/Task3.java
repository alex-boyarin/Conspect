package dateTimeDemo.task;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/*
 * Дана строка вида "26-03-1968Т09:24". Получить обьект LocalDateTime, представляющий собой дату,
 * полученную из этой строки.
 */
public class Task3 {
    public static void main(String[] args) {
        String formattedDate = "26-03-1968T09:24";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy'T'HH:mm");
        LocalDateTime localDateTime = LocalDateTime.parse(formattedDate, formatter);
        System.out.println(localDateTime);
    }
}
