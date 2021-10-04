package reGex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternFindExample {
    public static void main(String[] args) {
    /*
    Если в группе после первой скобки поставить вопросит. знак ? потом <  и написать имя группы >
    то можно к группе обращатся по имени а не по номеру. А если после всего регул выражения поставить
    двойной слеш и написать что мы хотим видеть в конце подстроки тоже что и в группе.
    Мы так же можем исключить группу из поиска для этого нужно послепервой скобки внутри группы
    поставить ?:
     */
        String phoneNumber = "^fhfduhguh +375 (33) 987-55-33 fjnhgihf f,ofm +375 (44) 777-55-44" +
                "tihykojupo +375 (29) 456-12-29 ptrok,f,bo+375 (25) 999-77-25;lk;oj$";
        String regex = "(?:\\+375)? ?\\((?<nameGroup>\\d{2})\\) ?\\d{3}-\\d{2}-\\1";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phoneNumber);
        while (matcher.find()) {
            System.out.println(matcher.group());
            System.out.println(matcher.group("nameGroup"));
        }
    }
}
