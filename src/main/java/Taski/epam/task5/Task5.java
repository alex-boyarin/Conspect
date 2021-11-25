package Taski.epam.task5;

import Taski.epam.task5.box.GiftInBox;

/**
 * Создать консольное приложение, удовлетворяющее следующим требованиям:
 * Корректно спроектируйте и реализуйте предметную область задачи.
 * Для создания объектов из иерархии классов продумайте возможность использования
 * порождающих шаблонов проектирования.
 * Реализуйте проверку данных, вводимых пользователем, но не на стороне клиента.
 * для проверки корректности переданных данных можно применить регулярные выражения.
 * Меню выбора действия пользователем можно не реализовывать, используйте заглушку.
 * Особое условие: переопределите, где необходимо, методы toString(), equals() и hashCode().
 * <p>
 * Вариант B. Подарки. Реализовать приложение,
 * позволяющее создавать подарки (объект, представляющий собой подарок).
 * Составляющими целого подарка являются сладости и упаковка.
 */
public class Task5 {
    public static void main(String[] args) {
        SweetGift sweetGift = new SweetGift();
        sweetGift.completeGift("cake", 1);
        sweetGift.completeGift("chocolate", 3);
        sweetGift.completeGift("candys", 2);
        sweetGift.completeGift("cake", 1);
        GiftInBox giftInBox = new GiftInBox(sweetGift);
        System.out.println(giftInBox);
    }
}
