package dateTimeDemo.task;

import java.time.LocalDateTime;

/*
 * Создать обьект LocalDateTime, Представляющий собой дату 25.06.2020 19:47. Используя этот обьект,
 * создать другой обьект LocalDateTime, представляющий собой дату через 3 месяца после сегодняшнего.
 * Вывести на консоль содержащиеся в нем обьекты LocalDate and LocalTime.
 */
public class Task1 {
    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.of(2020, 6, 25, 19, 47);
        LocalDateTime newLocalDateTime = localDateTime.plusMonths(3L);
        System.out.println(newLocalDateTime.toLocalDate());
        System.out.println(newLocalDateTime.toLocalTime());
    }
}
