package exceptionDemo;

import java.io.FileNotFoundException;
import java.util.concurrent.TimeoutException;

public class ExceptionExample2 {
    public static void main(String[] args) {
        System.out.println("main start");
        try {
            unsafe(2);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            try {
                unsafe(2);
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
                System.out.println("try in catch");
            } catch (TimeoutException timeoutException) {
                timeoutException.printStackTrace();
            }
        } catch (TimeoutException e) {
            e.printStackTrace();
        } finally {// Блок finally выполняется всегда независимо было исключение или нет.
            System.out.println("finally bloc");
            try {
                unsafe(3);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                System.out.println("try in finally");
            } catch (TimeoutException e) {
                e.printStackTrace();
            }
        }
//        try {
//            unsafe(2);
//        } catch (FileNotFoundException | TimeoutException e) {
//            e.printStackTrace();
//            //если мы используем обработку исключений одинаковую для разных исключ. то мы
//            //можем обьеденить эти исключ. в один блок catch используя побитовое "или"
        // только исключения не должны быть в иерархической зависимости.
//        }
        System.out.println("main end");
    }

    public static void unsafe(int value) throws FileNotFoundException, TimeoutException {
        //Пробрасывать можно несколько исключений, в таком случае они прописываются через запятую
        System.out.println("unsafe start");
        if (value > 0) {
            throw new FileNotFoundException();
        }
        System.out.println("unsafe end");
        //Если после пробрасываемого исключения идет код, то он не будет выполнятся
    }
}
