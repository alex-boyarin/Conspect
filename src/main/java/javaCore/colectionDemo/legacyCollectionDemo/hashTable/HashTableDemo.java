package javaCore.colectionDemo.legacyCollectionDemo.hashTable;

import java.util.Enumeration;
import java.util.Hashtable;

/* В java широко используются легаси коллекции, и представляют собой 4 коллекции. (HashTable<K,V>; Vector<E>;
 * Stack<E>; BitSet;)- они являются потока безопасными. Для которых в современном программировании
 * существуют аналоги. Понятно что не всегда потокобезоп. нужна, в опред. задачах она не требуется.
 * HashTable<K,V> -это Мар пара (ключ, значение). Vector<E>- это список.
 * Stack<E> -это список, который реализует Stack. BitSet- это битовое множество и сейчас практически не применяется.
 * Enumeration-это интерфейс аналог современного итератора. */
public class HashTableDemo {
    public static void main(String[] args) {
        Hashtable<String, Integer> hashtable = new Hashtable<>();
        hashtable.put("aaa", 12);
        hashtable.put("sss", 41);
        hashtable.compute("cccc",(k,v)->77);//добавление нового ключа со значением.
        System.out.println(hashtable);

        hashtable.computeIfPresent("cccc", (k, v) -> v + k.length()); // Если присутствует элемент, то он будет изменен.

        hashtable.putIfAbsent("ccc", 11);// Если элемент отсутствует он будет добавлен, если присутствует
        // то никаких изменений не произойдет.
        System.out.println(hashtable);

        Enumeration<String> keys = hashtable.keys(); // С начало извлечем итератор на ключи.
        while (keys.hasMoreElements()) {
            System.out.println(keys.nextElement());
        }
        Enumeration<Integer> elements = hashtable.elements();//итератор на значения.
        while (elements.hasMoreElements()) {
            System.out.println(elements.nextElement());
        }
    }
}
