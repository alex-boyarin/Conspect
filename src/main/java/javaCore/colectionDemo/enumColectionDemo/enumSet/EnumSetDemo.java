package javaCore.colectionDemo.enumColectionDemo.enumSet;

import java.util.EnumSet;
import java.util.Locale;

import static javaCore.colectionDemo.enumColectionDemo.enumSet.Country.*;

/* Колекция EnumSet -это множество которое в качестве своих элементов может содержать перечисления, причем
перечисл. только одного типа. Зачем оно нужно? Достаточно не редки задачи, когда нужно оперировать с частью элементов в
перечисл., например есть дни недели, а нам нужно работать только с рабочими днями. Конструктора подобных объектов
EnumSet в явном доступе нет, поэтому этот объект создается с помощью static методов. */
public class EnumSetDemo {
    public static void main(String[] args) {
        // Используем статический импорт чтобы не писать постоянно <Country.>
        EnumSet<Country> asiaCountries = EnumSet.of(ARMENIA, INDIA, KAZAKHSTAN);
        String nameCountry = "India";
        Country country = Country.valueOf(nameCountry.toUpperCase(Locale.ROOT));
        if (asiaCountries.contains(country)) {
            System.out.println("Asia");
        }
        asiaCountries.forEach(c -> c.grow(5));/*Добавляем население. В это варианте прибавление
        будет происходить ко всем странам. */
    }
}
