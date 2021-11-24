package functionalPrograming;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Stream для примитивных типов. Дело в том что все коллекц. как мы знаем не могут быть
 * параметризованны примитивными типами, но иногда нам нузно работать с примитивными типами данных
 * Для этого у нас есть 3 Stream для примитивных типов: IntStream, DoubleStream, LongStream
 * Что это нам позволяет. Дело в том что появляются несколько удобных методов
 */
public class StreamIntDoubleLongExample {
    public static void main(String[] args) {
        List<String> strings = List.of("88", "11", "22", "33", "44", "55", "66");
        IntSummaryStatistics intSummaryStatistics = strings.stream()
               //.map(string -> string + string)
               .map(Integer::valueOf)
//                .filter(value -> value % 2 == 0)
//                .sorted()
//                .limit(2)
                .mapToInt(Integer::intValue)// теперь после преобразования у нас появляются новые возможности
                //.max()//-получить максимальное значение
                //.min()//-минимальное значение
                //.sum()-посчитать сумму
                .summaryStatistics();//-вернет нам статистику
//               .getAverage()-средние значение     |
//                .getCount()-количество элементов  | Все эти методы можно вызывать по отдельности
//                .getMax()-максимальное значение    > а можно просто указать summaryStatistics()
//                .getMin()-минимальное значение    | и тогда эти методы реализуются полностью
//                .getSum()-сумма элементов         |
        // Так же мы можем преобразовать примитивный тип обратно в Object для этого мы вызываем
        // метод .mapToObj(Integer::valueOf)
        System.out.println(intSummaryStatistics);
        //.forEach(System.out::println);

        /* Мы можем создать Stream примитивных типов, для этого можно просто воспользоваться
        Static методом например IntStream.of() и просто передать туда все значения
         которые мы хотим. Так же мы можем это действие сделать и для Stream обьектов
         вызвав метод of()
        Stream.of("88", "11", "22", "33", "44", "55", "66");
        IntStream.of(1, 2, 3, 4, 5, 6, 7, 8, 9);*/
        List<String> collect = Stream.of("88", "11", "22", "33", "44", "55", "66")
                //.peek(System.out::println)//с помощь этого метода мы можем например вывести на экран
                //наш stream и продолжить далее работать
                .collect(Collectors.toList());// можно преобразовать в другую коллекцию
      // IntStream.range(0, 10)//-диапазон. Метод на подобии цикла for() где мы указываем диапазон
                //по которому мы хотим пройтись.
                //если мы хотим сделать диапазон включая последнее значение то используем
                //.rangeClosed()
             //   .forEach(System.out::println);
        /**
         * Более того мы можем создавать бесконечные iterator
         * таким образов в первый параметр мы помещаем первоначальное значение, к примеру "0"
         * а второй параметр это унарный оператор который будет нам возвращать новое значение
         * первоначального значения, таким образом цикл всегда будет продолжать потому-что мы не можем
         * дойти до конца этого потока. Но мы можем при помощи других методов его ограничить.
         */
//        IntStream.iterate(0, new IntUnaryOperator() { |
//            @Override                                 | старый ввариант
//            public int applyAsInt(int operand) {      |
//                return operand + 3;                   |
//            }
//        });
//        IntStream.iterate(0, operand -> operand + 3)
//                .skip(10)
//                .limit(20)
//                .forEach(System.out::println);
    }
}
