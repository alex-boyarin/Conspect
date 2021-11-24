package javaCore.colectionDemo.enumDemo.enumSet;

import java.util.EnumSet;
import java.util.Locale;

import static javaCore.colectionDemo.enumDemo.enumSet.Country.*;

/* Колекция EnumSet -это множество которое в качестве своих элементов может содержать перечисления, причем
перечисл. только одного типа. Зачем оно нужно? Достаточно не редки задачи, когда нужно оперировать с частью элементов в
перечисл., например есть дни недели а нам нужно работать только с рабочими днями. Конструктора подобных обьектов
EnumSet в явном доступе нету, поэтому этот обьект создается с помощью static методов.
*/
public class EnumSetDemo {
    public static void main(String[] args) {
        // Используем статестический импорт чтобы не писать постоянно <Country.>
        EnumSet<Country> asiaCountries = EnumSet.of(ARMENIA, INDIA, KAZAKHSTAN);
        String nameCountry = "India";
        Country country = Country.valueOf(nameCountry.toUpperCase(Locale.ROOT));
        if (asiaCountries.contains(country)) {
            System.out.println("Asia");
        }
        asiaCountries.forEach(c -> c.grow(1000000));//Добавляем население.
    }
}
