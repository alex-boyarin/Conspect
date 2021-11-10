package functionalPrograming;

import java.util.Comparator;

public class LamdaExample {
    public static void main(String[] args) {
//        Comparator<Integer> comparator = new IntegerComparator();
//        System.out.println(comparator.compare(25, 100));
        /**будем использовать лямда выражения

         так же мы уберем и тип из скобок, т.к. наш Comparator<Integer> уже параметризован*/
        // Comparator<Integer> comparator=(Integer o1, Integer o2)->{
        //   return Integer.compare(o1, o2);
        /**Если интерфейс который мы имплементируем содержит один только метод, то мы используем
         стрелочную функцию */
        // Comparator<Integer>comparator=((o1, o2) -> Integer.compare(o1,o2));
        /**так же мы можем пойти еще дальше и использовать "method reference"-ссылка на метод
         дело в том что Integer.compare() он принимает 2 параметра и возвращает один,
         следовательно если мы зайдем в наш  Comparator в метод compare() он точно так же принимает
         2 параметра. Главное знать что эти параметры совпадают с параметрами у Integer.compare()*/
        Comparator<Integer> comparator = Integer::compare;//"method reference"-ссылка на метод
        System.out.println(comparator.compare(25, 100));

        /**
         * Создадим свой Comparator, Сделаем static class который будет сортировать Integer
         * Имплементируем implements Comparator у которого содержится всего один метод
         * который мы должны переопределить
         */
//    private static class IntegerComparator implements Comparator<Integer> {

//        @Override
//        public int compare(Integer o1, Integer o2) {
//   return Integer.compare(o1,o2);// в классе Integer есть static метод compare()
//   который принимает два параметра и возвращает какое-то число(0,1,-1)
//        }

    }
}
/**
 * Кроме интерфейса Comparator у нас есть еще несколько основных функциональных интерф.
 * которые везде и всюду будут у нас использоваться.
 * 1. Function
 * 2. Predicate
 * 3. Consumer-Потребитель
 * 4. Supplier-Поставщик. По другому его еще называют Producer
 */
