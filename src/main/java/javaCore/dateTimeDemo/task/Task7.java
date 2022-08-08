package javaCore.dateTimeDemo.task;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/*
 * Создать обьект Instant. Вывести его на консоль. Затем создать обьект ZonedDateTime
 * на основании предыдущего обьекта с тайм зоной "Africa/Cairo".
 */
public class Task7 {
    public static void main(String[] args) {
        Instant instant = Instant.now();// таким образом мы получаем всемирное время
        System.out.println(instant);
        ZonedDateTime zonedDateTime = instant.atZone(ZoneId.of("Africa/Cairo"));
        System.out.println(zonedDateTime);
    }
}
