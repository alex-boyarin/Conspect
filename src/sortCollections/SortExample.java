package sortCollections;

import colectionDemo.Person;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortExample {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("123", "345", "14", "678");
        Collections.sort(strings);
        System.out.println(strings);
        List<Person> personList = Arrays.asList(
                new Person(2, "ivan", "ivanov"),
                new Person(25, "boris", "petrov"),
                new Person(4, "sveta", "svetikova"),
                new Person(3, "ivan", "Golubok"));

//        Collections.sort(personList);
//        System.out.println(personList);
//        Collections.sort(personList,new FirstNameComparator());
//        System.out.println(personList);
       personList.sort(new FirstNameComparator());

        personList.sort(Comparator.comparing((Person person) -> person.getFirstName()).thenComparing(Person::getLastName));
        System.out.println(personList);
    }

    public static class FirstNameComparator implements Comparator<Person> {

        @Override
        public int compare(Person o1, Person o2) {
            return o1.getFirstName().compareTo(o2.getFirstName());
        }
    }
}
