package javaCore.dateTimeDemo;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class DateTimeDemo {
    public static void main(String[] args) {
        ZonedDateTime zonedDateTime = ZonedDateTime.now();//Для того чтобы получить текущее время
        System.out.println("1). " + zonedDateTime);

        /*toEpochMilli()- выводит все количество милисекунд с 1970 г.
        И получить это значение мы можем только у toInstant()*/
        long toEpochMill = zonedDateTime.toInstant().toEpochMilli();
        System.out.println("2). " + toEpochMill);

        /* Так же мы можем изменить наш обьект времени к примеру на 1 день, хотя это можно сделать с
        любым показателем (минуты, часы, секунды, месяц, год)*/
        ZonedDateTime plus = zonedDateTime.plus(1L, ChronoUnit.DAYS);
        System.out.println("3). " + plus);

        /* так же есть методы специальные по сумме*/
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
        System.out.println("4). " + minus);
        /* так же есть методы специальные по отниманию*/
//        minus = zonedDateTime.minusDays();
//        minus = zonedDateTime.minusHours();
//        minus = zonedDateTime.minusMinutes();
//        minus = zonedDateTime.minusMonths();
//        minus = zonedDateTime.minusNanos();
//        minus = zonedDateTime.minusSeconds();
//        minus = zonedDateTime.minusWeeks();
//        minus = zonedDateTime.minusDays();
//        minus = zonedDateTime.minusYears();

        /* Этим методом мы обнуляем нашу дату, к примеру если мы хотим это сделать до дня,
         то будут обнулены все часы, минуты, секунды, миллисекунды */
        ZonedDateTime zonedDateTime1 = zonedDateTime.truncatedTo(ChronoUnit.DAYS);
        System.out.println("5). " + zonedDateTime1);

        // Невероятное большое количество getter
        System.out.println("6). " + zonedDateTime.getDayOfMonth());
        System.out.println("7). " + zonedDateTime.getDayOfWeek());
        System.out.println("8). " + zonedDateTime.getDayOfYear());
        System.out.println("9). " + zonedDateTime.getHour());
        System.out.println("10). " + zonedDateTime.getMinute());
        System.out.println("11). " + zonedDateTime.getMonth());
        System.out.println("12). " + zonedDateTime.getZone());
        System.out.println("13). " + zonedDateTime.getMonthValue());
        System.out.println("14). " + zonedDateTime.getYear());

//        zonedDateTime.format() - Метод для преобразования даты в строку

        /*        Методы проверяющие является эта дата чему-то.*/
//        zonedDateTime.isAfter();-После какой-либо даты
//        zonedDateTime.isBefore();-Перед какой-либо даты
//        zonedDateTime.isEqual();-сравнение дат

        LocalDateTime localDateTime = LocalDateTime.now(ZoneOffset.UTC);
        System.out.println("15). " + localDateTime);
        LocalTime localTime = LocalTime.now();
        System.out.println("16). " + localTime);
        /*Работа с Calendar*/
        Calendar gregorianCalendar = new GregorianCalendar();//можно присвоить ссылку на обьект GregorianCalendar()
        Calendar gregorianCal = Calendar.getInstance();//можно вызвать статический метод .getInstance() и так же получить
        //GregorianCalendar()
        gregorianCal.set(2004, 1, 15, 10, 20);//устанавливаем дату и время
        long day = gregorianCal.getTimeInMillis();//в частности, количество миллисекунд,
        // которое прошло с первого января 1970 года. Это дает возможность выполнять точные вычисления
        // разницы между двумя датами. Например, можно добавить к данному времени 63 часа 23 минуты и 12 секунд.
        System.out.println("17). " + day);
        day += 1000 * 60 * 60;//добавляем определенное кол-во миллисекунд
        System.out.println("18). " + day);
        gregorianCal.setTimeInMillis(day);
        System.out.println("новый час " + gregorianCal.get(gregorianCal.HOUR_OF_DAY));
        gregorianCal.add(gregorianCal.DATE, 35);//добавляем к дате 35 дней
        System.out.println("добавляем к дате 35 дней " + gregorianCal.getTime());
        gregorianCal.roll(gregorianCal.DATE, 35);
        System.out.println("Прокрутить 35 дней " + gregorianCal.getTime());
        gregorianCal.set(Calendar.DATE, 1);
        System.out.println("Установить дату в 1 " + gregorianCal.getTime());
    }
}
