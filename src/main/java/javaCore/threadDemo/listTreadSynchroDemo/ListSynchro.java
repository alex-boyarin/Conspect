package javaCore.threadDemo.listTreadSynchroDemo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListSynchro {
    public static void main(String[] args) {
        //List<Integer> integers = new ArrayList<>();
        List<Integer> integers = Collections.synchronizedList(new ArrayList<>());// синхр. обертка
        ListTread listTread1 = new ListTread(integers);
        ListTread listTread2 = new ListTread(integers);
        ListTread listTread3 = new ListTread(integers);
        ListTread listTread4 = new ListTread(integers);
        ListTread listTread5 = new ListTread(integers);
        ListTread listTread6 = new ListTread(integers);
        ListTread listTread7 = new ListTread(integers);
        ListTread listTread8 = new ListTread(integers);
        ListTread listTread9 = new ListTread(integers);
        String s = new String();
        listTread1.start();
        listTread2.start();
        listTread3.start();
        listTread4.start();
        listTread5.start();
        listTread6.start();
        listTread7.start();
        listTread8.start();
        listTread9.start();

        try {
            listTread1.join();
            listTread2.join();
            listTread3.join();
            listTread4.join();
            listTread5.join();
            listTread6.join();
            listTread7.join();
            listTread8.join();
            listTread9.join();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        integers.forEach(System.out::println);
    }
}
