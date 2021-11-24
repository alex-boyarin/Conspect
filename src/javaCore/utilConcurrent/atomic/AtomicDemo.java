package javaCore.utilConcurrent.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Создадим AtomicInteger() у него есть два конструктора, один без парам., а другой принимает int,
 * это начальное значение нашего atomic, по сути это наша оболочка над примитивным типом int
 * только потокобезопасная, следовательно мы можем передать примотивное значение или вообще не
 * устанавливать значение, тогда оно будет равно "0"
 */
public class AtomicDemo {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger();
        /*
        в AtomicInteger() в многопоточн. мы можем без проблем использовать методы incrementAndGet(),
        либо добавить определенное значение и получить результат addAndGet(5),
        так же можно сделать и decrementAndGet() т.е. отнять и получить результат.
         */
        int value = atomicInteger.incrementAndGet();//сразу возвр. значение которое получили после добавления.
        int value1 = atomicInteger.addAndGet(5);//добавить определенное значение и получить результат.
        // value = atomicInteger.decrementAndGet();//отнять и получить результат.
        System.out.println(value);
        System.out.println(value1);
    }
}
