package lll1234.EnamTest;

public class Recursiay {
    public static void main(String[] args) {
        int factorial = factorial(6);
        System.out.println(factorial);
    }

    public static int factorial(int value) {
        if (value == 1) {
            return 1;
        }
        return value * factorial(value - 1);
    }
}
