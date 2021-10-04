package colectionDemo.legacyCollectionDemo.hashTable;

import java.util.Enumeration;
import java.util.Hashtable;

/*
 * В java широко используются легаси колекции, и представляют собой 4 колекции. (HashTable<K,V>; Vector<E>;
 * Stack<E>; BitSet;)- они являются потокабезопасными. Enumeration. Для которых в современном программировании существуют аналоги, отличие их в том что они
 * являются потокабезопасными. Понятно что не всегда потокобезоп. нужна, в опред. задачах она не требуется.
 * HashTable<K,V> -это Мар пара (ключ, значение). Vector<E>- это список. Stack<E> -это список который реализует Stack.
 * BitSet- это битовое множество и сейчас практически не применяется. Enumeration-это интерфейс аналог современого итератора.
 */
public class HashTableDemo {
    public static void main(String[] args) {
        Hashtable<String, Integer> hashtable = new Hashtable<>();
        hashtable.put("aaa", 12);
        hashtable.put("sss", 41);
        //hashtable.compute("cccc", (k, v) -> 77);
        // hashtable.computeIfPresent("cccc", (k, v) -> v + k.length()); // Если присуствует элемент то он будет изменен.
        hashtable.computeIfAbsent("cccc", v -> 11);// Если элемент отсуствует он будет добавлен, если присуствует
        // то никаких изменений не произойдет.
        System.out.println(hashtable);
        Enumeration<String> keys = hashtable.keys(); // Сначало извлечем итератор на ключи, и отдельно итератор на значения.
        while (keys.hasMoreElements()) {
            System.out.println(keys.nextElement());
        }
        Enumeration<Integer> elements = hashtable.elements();
        while (elements.hasMoreElements()) {
            System.out.println(elements.nextElement());
        }
    }
}
