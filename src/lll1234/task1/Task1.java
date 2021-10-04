package lll1234.task1;

public class Task1 {
    public static void main(String[] args) {
        String value = " hedebdb :(knrnvjnrj :( hdjbchb :) jncjn";
        String result = replace(value);
        System.out.println(result);
    }

    public static String replace(String value) {
        return value.replace(":(", ":)");
    }
}
