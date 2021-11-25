package javaCore.dateTimeDemo.task;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

/*
 * Создать обьект LocalDate, представляющий собой сегодняшнюю дату. Создать обьект LocalDate
 * представляющий собой дату 07.07.2018. Используя созданные обьекты, найти количество дней между
 * этими двумя датами.
 */
public class Task5 {
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();//текущая дата
        LocalDate prevDate = LocalDate.of(2018, 7, 7);// а сдесь мы создаем конкретную дату

        /* Period позволяет найти  год, месяц, день между 2мя датами
        Duration позволяет найти с точностью до долей секунд
         */
        Period period = Period.between(prevDate, localDate);//этот метод позволяет нам находить год, месяц, день между 2мя датами
        System.out.println(period.getYears() + "\n" +
                period.getMonths() + "\n" +
                period.getDays());
/*
Если нам необходимо посчитать кол-во именно дней между двумя точками,
 то тогда воспользуемся ChronoUnit.DAYS и у него воспользуемся методом between() и передать в
 него любые 2 Temporal
 */
        long between = ChronoUnit.DAYS.between(prevDate, localDate);
        System.out.println(between);
    }
}
