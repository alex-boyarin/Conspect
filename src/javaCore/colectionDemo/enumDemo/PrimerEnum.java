package javaCore.colectionDemo.enumDemo;

public enum PrimerEnum {//   // Almaz_7788, Stolitsa_135, Vip_107, chrystal_7778, TaxiCargo_163-так нельзя обьявлять перечисления
    //    ALMAZ(7788), STOLITSA(135), VIP(107), CHRYSTAL(7778), TAXI_CARGO(163);
//    private int phoneNumber;
//
//    PrimerEnum(int phoneNumber) {
//        this.phoneNumber = phoneNumber;
//    }
    AIRBUS, BOEING
}
/**
 * Далее будут идти примеры как нельзя и как нужно обьявлять перечисления:
 * Пример 2
 * AIRBUS_A320, AIRBUS_A380, AIRBUS_A330, BOEING_737_800, BOEING_777----ТАК НЕ ПРАВЕЛЬНО!!!
 * Создаем перечисление PlaneProducer{
 * AIRBUS, BOEING
 * }
 * Далее создаем отдельный класс, в котором содержится переменая типа производит. самолетов,
 * и поле модели самолетов
 * Plane{
 * privat PlaneProducer producer;
 * privat String model;
 * }
 */

