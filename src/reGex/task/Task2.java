package reGex.task;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Написать программу, выполняющую поиск в строке шестнадцатеричных чисел, записаных по правилам Java
 * с помощью регулярных выражений и выводящую их на страницу.
 */
public class Task2 {
    public static void main(String[] args) {
        String regex = "0[xX][0-9a-fA-f]+";
        String input = "hvfbhfdbvhfb 0xff khi 0x14yjm 0Xab";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
