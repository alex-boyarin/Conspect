package reGex.task;

import java.util.regex.Pattern;

/**
 * Написать программу, проверяющую, является ли введенная строка адресом почтового ящика.
 * В названия разрешить использование только букв, цифр и нижнего подчеркивания, при этом
 * оно должно начинаться с буквы. Возможные доменны верхнего уровня: .org  .com
 */
public class Task1 {
    public static void main(String[] args) {
        String regex = "[a-zA-Z]\\w*@\\w{3,}\\.(org|com)";
        String input = "fhbfbvb@gmail.com";
        System.out.println(Pattern.matches(regex, input));
    }
}
