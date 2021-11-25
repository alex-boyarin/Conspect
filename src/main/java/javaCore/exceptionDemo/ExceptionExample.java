package javaCore.exceptionDemo;

import java.io.FileNotFoundException;
import java.util.concurrent.TimeoutException;

/* Исключения отлавливаются в блоке catch, таких блоков может быть сколько угодно.
 * Есть одно правило, исключения должны распологатся от потомка к предку по иерархии,
 * т.е. сверху в низ. Если этого не соблюдать то возможна ситуация когда в следущий
 * catch программа просто не зайдет т.к. исключение предназначеное для него, отловит
 * предыдущий блок.
 */
public class ExceptionExample {
    public static void main(String[] args) {
        System.out.println("main start");
//        try {
//            unsafe(-2);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (TimeoutException e) {
//            e.printStackTrace();
//        }
        try {
            unsafe(2);
        } catch (FileNotFoundException | TimeoutException e) {
            e.printStackTrace();
            //если мы используем обработку исключений одинаковую для разных исключ. то мы
            //можем обьеденить эти исключ. в один блок catch используя побитовое "или"
            // только исключения не должны быть в иерархической зависимости.
        }
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
