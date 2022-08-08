package javaCore.reGex.task;

import java.util.List;
import java.util.Locale;

record Item(String name, double amount) {

}

public class Task4 {
    public static void main(String[] args) {
        Item item = new Item("ddd", 1.0);
        List<String> words = List.of("john", "jack", "phillip", "antoni", "pit");
        List<Character> result = words.stream()
                .filter(w -> w.matches("[a-p]+"))
                .map(w -> w.charAt(2))
                .toList();
        System.out.println(result);
        System.out.println(item.name().toUpperCase(Locale.ROOT));
    }
}
