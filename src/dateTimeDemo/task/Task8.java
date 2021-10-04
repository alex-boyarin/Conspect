package dateTimeDemo.task;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/*
 * Написать свою реализацию интерфейса TemporalAdjuster, которая бы прибавляла к дате 42 дня
 */
public class Task8 {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        /*
        Сдесь мы моглибы просто использовать метод plusDays() но представте что у нас есть
        много дат и ко всем этим датам необходимо вызвать  plusDays(), либо сколько этих дней,
        месяцев или лет мы не знаем.
        Следовательно у java 8 есть метод который называется with(TemporalAdjuster adjuster)
        который принимает TemporalAdjuster adjuster, и в нем мы можем указать любое изменение нашей даты.
        Перейдя в него мы видим что это функциональный интерфейс,
        в нем есть один метод adjustInto(Temporal temporal). Temporal-это наш базовый класс для всех
        DateTime и он просто изменяет нашу дату, следовательно в нашем случае мы говорим вот наш обьект
        temporal в данном случае придет наш  "now" и все что нам необходимо сделать через базовый класс
        мы имеем доступ ко всем базовым методам которые унаследовались всеми другими нашими классами
        LocalDate LocalDatetime ZonedTime  и т.д. т.е они все унаследовались от  нашего  Temporal

        И в данном случае мы должны прибавить к нему 42 дня т.е. делаем plus
         */
        LocalDateTime localDateTime = now.with(temporal -> temporal.plus(42L, ChronoUnit.DAYS));
        System.out.println(localDateTime);
        /* Таким образом с помощью TemporalAdjuster мы можем работать на уровне нашего совсем
         базового класса Temporal для того чтобы изменять любой обьект из нашей иерархии дат и времени.
         */
    }
}
