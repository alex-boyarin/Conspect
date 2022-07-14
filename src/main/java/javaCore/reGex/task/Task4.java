package javaCore.reGex.task;

import java.util.List;

public class Task4 {
    public static void main(String[] args) {
        List<String> words = List.of("john", "jack", "phillip", "antoni", "pit");
        List<Character>result=words.stream()
                .filter(w->w.matches("[a-p]+"))
                .map(w->w.charAt(2))
                .toList();
        System.out.println(result);
    }
}
