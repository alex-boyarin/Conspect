package dateTimeDemo;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

public class DateTimeDemo {
    public static void main(String[] args) {
        ZonedDateTime zonedDateTime = ZonedDateTime.now();//Для того чтобы получить текущее время
        System.out.println(zonedDateTime);

        //toEpochMilli()- выводит все количество милисекунд с 1970 г. И получить это значение мы можем
        //только у toInstant()
        long toEpochMilli = zonedDateTime.toInstant().toEpochMilli();
        System.out.println(toEpochMilli);

        // Так же мы можем изменить наш обьект времени к примеру на 1 день, хотя это можно сделать с
        //любым показателем (минуты, часы, секунды, месяц, год)
        ZonedDateTime plus = zonedDateTime.plus(1L, ChronoUnit.DAYS);
        System.out.println(plus);

//так же есть методы специальные по сумме
//        plus = zonedDateTime.plusDays();
//        plus = zonedDateTime.plusHours();
//        plus = zonedDateTime.plusNanos();
//        plus = zonedDateTime.plusMinutes();
//        plus = zonedDateTime.plusMonths();
//        plus = zonedDateTime.plusSeconds();
//        plus = zonedDateTime.plusSeconds();
//        plus = zonedDateTime.plusWeeks();
//        plus = zonedDateTime.plusYears();

        ZonedDateTime minus = zonedDateTime.minus(1L, ChronoUnit.DAYS);
        System.out.println(minus);
        //так же есть методы специальныепо отниманию
//        minus = zonedDateTime.minusDays();
//        minus = zonedDateTime.minusHours();
//        minus = zonedDateTime.minusMinutes();
//        minus = zonedDateTime.minusMonths();
//        minus = zonedDateTime.minusNanos();
//        minus = zonedDateTime.minusSeconds();
//        minus = zonedDateTime.minusWeeks();
//        minus = zonedDateTime.minusDays();
//        minus = zonedDateTime.minusYears();

        // Этим методом мы обнуляем нашу дату, к примеру если мы хотим это сделать до дня,

        // то будут обнулены все часы, минуты, секунды , милисекунды
        ZonedDateTime zonedDateTime1 = zonedDateTime.truncatedTo(ChronoUnit.DAYS);
        System.out.println(zonedDateTime1);

        // Невероятное большое количество getter
        System.out.println(zonedDateTime.getDayOfMonth());
        System.out.println(zonedDateTime.getDayOfWeek());
        System.out.println(zonedDateTime.getDayOfYear());
        System.out.println(zonedDateTime.getHour());
        System.out.println(zonedDateTime.getMinute());
        System.out.println(zonedDateTime.getMonth());
        System.out.println(zonedDateTime.getZone());
        System.out.println(zonedDateTime.getMonthValue());
        System.out.println(zonedDateTime.getYear());

        //  zonedDateTime.format()-Метод для преобразования даты в строку
// Методы проверяющие является эта дата чему-то.
//        zonedDateTime.isAfter();-После какой либо даты
//        zonedDateTime.isBefore();-Перед какой либо даты
//        zonedDateTime.isEqual();-сравнение дат

        LocalDateTime localDateTime = LocalDateTime.now(ZoneOffset.UTC);
        System.out.println(localDateTime);
        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);
    }
}
