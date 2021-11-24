package javaCore.reGex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Replace {
    public static void main(String[] args) {
        String phoneNumber = "^fhfduhguh +375 (33) 987-55-33 fjnhgihf f,ofm +375 (44) 777-55-44" +
                "tihykojupo +375 (29) 456-12-29 ptrok,f,bo+375 (25) 999-77-25;lk;oj$";
        String regex = "(?:\\+375)? ?\\((?<nameGroup>\\d{2})\\) ?(\\d{3})-(\\d{2})-(\\d{2})";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phoneNumber);
        StringBuffer stringBuffer = new StringBuffer();//потокобезопасн. аналог StringBuilder
        while (matcher.find()) {
            String gr1 = matcher.group(2);
            String gr2 = matcher.group(3);
            String gr3 = matcher.group(4);
            matcher.appendReplacement(stringBuffer, "$2 $3 $4");
        }
        matcher.appendTail(stringBuffer);
        System.out.println(stringBuffer);
        System.out.println(phoneNumber.replaceAll(regex, "$2 $3 $4"));
    }
}
