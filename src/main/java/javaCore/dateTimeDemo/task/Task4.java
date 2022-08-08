package javaCore.dateTimeDemo.task;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/*
 * Использовать LocalDateTime из предыдущего задания, преобразовать его в обьект типа Instant,
 *  указав тайм зону "America/Chicago". Вывести кол-во прошедших миллисекунд.
 */
public class Task4 {
    public static void main(String[] args) {
        String formattedDate = "26-03-1968T12:00";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy'T'HH:mm");
        LocalDateTime localDateTime = LocalDateTime.parse(formattedDate, formatter);
        System.out.println(localDateTime);
        /*
         * Если мы хотим localDateTime преобразовать в instant мы должны передать туда ZoneId.of("")
         * и далее мы получаем getRules() и через него getOffset(localDateTime)
         * Зону можно создавать на основании ее индетификатора, их все можно посмотреть на оф. сайте
         */
        Instant instant = localDateTime.toInstant(ZoneId.of("America/Chicago").getRules().getOffset(localDateTime));
        System.out.println(instant);
        System.out.println(instant.toEpochMilli());

    }
}
