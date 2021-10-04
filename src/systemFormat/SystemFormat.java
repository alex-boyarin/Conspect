package systemFormat;

import java.text.DecimalFormat;
import java.util.Date;

public class SystemFormat {
    public static void main(String[] args) {
        System.out.printf("Привет %n Привет");// Разделитель строк для конкретной платформы. Аналог \n
        System.out.printf("Привет %s!%n", "мир");// Любой тип, который будет приведен к строке.
        System.out.printf("Привет %b!%n", null);/* Любой тип, который будет приведен к boolean:
        true — если значение не null, false — если null*/
        System.out.printf("Привет %h!%n", "мир");/* Можно передавать любой объект,
        который будет приведен к шестнадцатеричной строке значения из метода hashCode ()*/
        System.out.printf("Привет м%cр!%n", 'и');// Используется для задания символа Unicode (char)
        System.out.printf("Мне уже %5d!%n", 20);// Задается целое число (int. byte, short, int, long, BigInteger)
        System.out.printf("Число ПИ равно -  %f!%n", 3.14159);// Используется для задания числа с плавающей запятой
        System.out.printf("Число ПИ равно -  %e!%n", 3.14159);// Числа с плавающей запятой в экспоненциальном представлении
        System.out.printf("Число ПИ равно -  %a!%n", 3.14159);// Числа с плавающей запятой будут представлены в шестнадцатеричном виде
        System.out.printf("Мне уже %x!%n", 25);/* Передается целое число (int. byte, short, int, long, BigInteger),
        результатом форматирования будет символ под данным номером в таблице ASCII*/
        System.out.printf("Мне уже %o!%n", 25);/* Принимается целое число (int. byte, short, int, long, BigInteger),
        которое будет представлено в виде восьмеричного числа */
        System.out.printf("Сегодня %tA%n", new Date());/* Префикс для преобразований даты и времени.
        Для форматирования требуются дополнительные флаги*/
        System.out.printf("Расстояние от Киева до Одессы - %4.6f." +
                " Не так уж и мало, не правда ли?  %n", 475.4d);
        System.out.printf("Расстояние от Киева до Одессы - %.2f." +
                " Не так уж и мало, не правда ли? %n ", 475.4d);
        //DecimalFormat decimalFormat = new DecimalFormat("#.###");
        double value = 72.224463;
        //System.out.println(decimalFormat.format(value));
        System.out.println(new DecimalFormat("###,###.##").format(74554542.224463));
        System.out.println(new DecimalFormat("%###.##").format(0.723456));
        System.out.println(new DecimalFormat("0000000000").format(.22211133));
        System.out.printf("%4d%n", 2);
        System.out.printf("%4d%n", 21);
        System.out.printf("%4d%n", 211);
        System.out.printf("%5d%n", 2113);
        System.out.printf("%10s", "1234567890 gggggg");
//        Scanner scanner=new Scanner(System.in);
//        double ff=scanner.nextDouble();
//        System.out.println(ff);

    }
}
