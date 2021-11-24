package javaCore.functionalPrograming;

import java.util.Optional;
import java.util.stream.Stream;

/*
 * Optional класс это опциональный тип который может бы а может и нет. Это обычный final класс
 * который  параметризован одним единственным типом. Если Stream это поток множества обьектов,
 * то Optional это один единственный обьект, который может бы а может и нет.
 */
public class OptionalExample {
    public static void main(String[] args) {
        Optional<StudentMap> maybeStudent = Stream.of(
                        new StudentMap(17, "ivan"),
                        new StudentMap(22, "petr"),
                        new StudentMap(33, "vasya"),
                        new StudentMap(44, "sveta"),
                        new StudentMap(21, "katya"),
                        new StudentMap(69, "den"),
                        new StudentMap(100, "ira"))
                //.flatMap(studentMap -> studentMap.getMarks().stream())
                .sequential()
                .filter(student -> student.getAge() < 18)//фильтр по возрасту
                .reduce((student1, student2) -> student1.getAge() > student2.getAge() ? student1 : student2);
        maybeStudent.ifPresent(System.out::println);//если этот обьект есть то он выведится на консоль
        maybeStudent.map(StudentMap::getAge)//метод такой же как и у Stream, он преобразует обьект Optional в другой который мы захотим
                .filter(age -> age > 25)//такой же фильтр как и у Stream
                //.ifPresent()//проверяет есть ли там обьект или нет.
                /* если мы все-таки хотим получить какое-то значение и не хотим вызываить ifPresent
                то мы можем использовать несколько методов or() т.е. вызвать or(и передать в него другой Optional)
                далее мы можем вызвать orElseThrow() он возвращает Integer но выбрасывает исключение если там
                ничего нет. Так же у нас есть другой orElse(Integer other) который возвращает другой Integer
                в место нашего. Так же есть еще несколько методов которые мы со временем изучим */
                //.or()
                //.orElse()
                //.orElseThrow()
                //.ifPresentOrElse();//очень часто в java-8 нехватало этого метода и в последующих
                // версиях его добавили
                /* Так же мы можем преобразовать наш  Optional в Stream, так же очень удобный механизм
                посути мы преобразовываем в Stream из одного обьекта.
                .flatMap() очень схож с нашим методом map() Различие лишь в том что в данном случае в метод
                переходит наше значение которое храниться в Optional и возвращается тоже Optional мы обязаны
                вернуть Optional
                 */
                //пример:
                .flatMap(age -> Optional.of(age * 2));
    }
}
