package javaCore.colectionDemo.setDemo;

import java.util.Set;
import java.util.TreeSet;

/* У Set нет метода sort, и так же при вызове Collections.sort() мы не можем передать
 * в него Set. И так как Set настолько отличается от List мы не можем получить значение по индексу
 * т.е. у нас нет метода get. И все что мы можем сделать это только пройтись итератором
 * по коллекции и посмотреть какие есть значения set.forEach */
public class TreeSetDemo {
    public static void main(String[] args) {

        //Если нам нужно чтобы элементы располагались в порядке возрастания, то нужно
        //использовать реализацию TreeSet<>
        Set<String> treeSet = new TreeSet<>();
        treeSet.add("h");
        treeSet.add("h");//дубликаты не допускаются
        treeSet.add("z");
        treeSet.add("y");
        treeSet.add("x");
        treeSet.add("w");
        treeSet.add("v");
        treeSet.add("u");
        treeSet.add("t");
        treeSet.add("s");
        treeSet.add("r");
        treeSet.add("q");
        treeSet.add("p");
        treeSet.add("o");
        treeSet.forEach(System.out::print);
    }
}
