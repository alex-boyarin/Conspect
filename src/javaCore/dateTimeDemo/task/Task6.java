package javaCore.dateTimeDemo.task;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;

/*
 * Даны два обьекта LocalDate из предыдущего задания. Подсчитать количество секунд
 * между полуночи первой даты и полуночи второй даты.
 */
public class Task6 {
    public static void main(String[] args) {
        /*
        Period мы используем для получения количества дней, месяцев или лет
         */
        LocalDate now = LocalDate.now();
        LocalDate prevDate = LocalDate.of(2018, 7, 7);

        // LocalDateTime localDateTime = LocalDateTime.of(now, LocalTime.MIDNIGHT);
        LocalDateTime localDateTimeNow = now.atStartOfDay();
        LocalDateTime localDateTimePrev = prevDate.atStartOfDay();
        /*
        Duration используется для более точного промежутка между 2 датами
         */
        Duration duration = Duration.between(localDateTimePrev, localDateTimeNow);
        System.out.println(duration.getSeconds());
    }
}
