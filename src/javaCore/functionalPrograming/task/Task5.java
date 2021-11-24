package javaCore.functionalPrograming.task;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import static java.util.stream.Collectors.*;
import static java.util.stream.Collectors.toMap;

/*
 * Дан класс Person с полями.
 * Вывести полное имя самого старшего человека, у которого
 * длина этого именине не превышает 15 символов.
 */
public class Task5 {
    public static void main(String[] args) {
        List<Person> persons = List.of(
                new Person("ivan", "ivanov", 20),
                new Person("petr", "petrov", 25),
                new Person("sveta", "svetikova", 33),
                new Person("slava", "slavikov", 45),
                new Person("arni", "kutuzov", 56),
                new Person("kate", "ivanova", 25)
        );
        /**
         * Нам нужно представить все в виде Stream далее filter() далее метод max() т.к. он
         * быстрее находит необходимы для нас значения,
         * далее в методе max(мы вызываем статический метод Comparator.comparing(Person::getAge)
         * Естественно по умолчанию у нас используется сортировка от меньшего к большему,
         * но нас это не волнует т.к. мы используем метод нахождения максимального элемента.
         * Далее мы можем вывести полное имя старшего человека, поэтому дальше мы преобразовываем
         * нашего найденого Person и получаем из него только fullName,
         * теперь мы работаем только с Optional т.к. max() возвращает нам только один элемент
         * и дальше мы продолжем работать только с одним элементом, естествено он может быть или нет.
         * Поэтому мы можем воспользоваться map() у нашего Optional и сказать дай нам getFullName
         * и если он существуе вывести его на консоль.
         */
        persons.stream()
                .filter(person -> person.getFullName().length() < 15)
                .max(Comparator.comparing(person1 -> person1.getAge()))
                .map(Person::getFullName)
                .ifPresent(System.out::println);
/**
 * Для примера сделаем еще один пример чтобы представить наших Person в виде Map
 * где ключом будет возраст а значением сам Person. По одному возрасту у нас может быть несколько
 * Person, следовательно посмотрим как это можно реализовать.
 * Так же делаем stream тут нам не надо ничего фильтровать, мы всего лишь хотим преобразовать
 * наш список Person в map() где ключом будет возраст а значением все Person одного и того же возраста
 * поэтому мы воспользуемся методом collect()  и сдесь у collect(Collectors.groupingBy(Person::getAge))
 * есть метод groupingBy() он принимает функцию которая на вход принимает Person и возращает
 * значение по которым нужно групировать, по сути это ключ и естественно ели ключ будет одинаковый
 * то в итоге мы получим несколько Person по одному и тому же ключу.
 */
        Map<Integer, List<Person>> map = persons.stream()
                .collect(groupingBy(Person::getAge));
        System.out.println(map);
        /**
         * Следовательно мы можем пойти еще дальше если нам не нужны Person,
         * а нужны только полные имена этих Person. В  Collectors.groupingBy(Person::getAge) есть перегрузка,
         * мы можем воспользоваться collector  который поможет нам преобразовать получившегося Person.
         * collect(Collectors.groupingBy(Person::getAge, Collectors.mapping())).
         * Collectors.mapping()-принимает два параметра, первое это функцию т.е. преобразование нашего Person,
         * и второй во что мы хотим преобразовать, пример List, Set... или что-то еще.
         * Естественно когда очень часто повторяются методы лучше делать static import чтобы
         * укоротить и улучшить читаемость кода
         * пример 2:
         */
        Map<Integer, List<String>> map1 = persons.stream()
                .collect(groupingBy(Person::getAge,
                        mapping(Person::getFullName, toList())));
        System.out.println(map1);

        /**
         * Конечно мы можем преобразовывать сразу в Map<> , в таком случае мы обязаны соблюдать уникальность
         * нашего ключа т.е. где ключом например будет Integer а значение именно один обьект типа Person
         * Для этого мы просто вызовем Collect(toMap(Person::getAge, Function.identity())) тогда
         * мы можем сказать что ключом будет Person::getAge, а значение сам Person.
         * Конечно это не будет работать если у нас не будет уникально ключа.
         */
        Map<Integer, Person> personMap = persons.stream()
                .collect(toMap(Person::getAge, Function.identity()));
    }
}
