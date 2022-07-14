package javaCore.colectionDemo.legacyCollectionDemo.vector;

import java.util.Enumeration;
import java.util.Objects;
import java.util.Vector;

/*
 * Является полностью потокобезопасен. И представляет собой список.
 * Из-за того что он явл. потокобез. соответствено более медленный чем классы появившееся во 2 java, в частности
 * потомки интерфейса листа, а так же с появлением ограниченных потокобезопасн. колекц. в java 5,
 * современное применение вектора достаточно ограниченно. Тем не менее встречается он в веб разработке достаточно
 * часто
 */
public class VectorDemo {
    public static void main(String[] args) {
        Vector<String> vector = new Vector<>();
        vector.add("java");
        vector.add("belarus");
        vector.add(1, null);//вектор может содержать null.
        vector.addAll(vector);//Так же можно добавить другую колекц. или эту же коллукцию.
        System.out.println(vector);
        vector.removeIf(e->e==null);
        vector.replaceAll(String::toUpperCase);// Можно привести все элементы к верхнему регистру
/* (но для этого в предыдущем методе мы удалим все null, чтобы не получить ошибку)!!!*/
        System.out.println(vector);
// так же можно преобразовать в Стрим, и например вывести размер.
        int size = (int) vector.stream().count();
        System.out.println(size);
//так же этот класс явл. итерируемым.
        Enumeration<String> enumeration = vector.elements();
        while (enumeration.hasMoreElements()) {
            System.out.println(enumeration.nextElement());
        }
    }
}
