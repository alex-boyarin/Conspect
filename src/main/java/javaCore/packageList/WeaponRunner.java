package javaCore.packageList;

import Taski.hero.Archer;
import Taski.hero.Mage;
import Taski.hero.Warrior;
import Taski.hero.weapon.Bazooka;
import Taski.hero.weapon.Sword;
import Taski.hero.weapon.Wand;

public class WeaponRunner {
    public static void main(String[] args) {
        Archer<Bazooka> archer = new Archer<>("Petya", 25);
        archer.setWeapon(new Bazooka());
        Warrior<Sword> warrior = new Warrior<>("Lenya", 10);
        warrior.getWeapon();
        Mage<Wand> mage = new Mage<>("Vasya", 15);
        mage.getWeapon();
    }
}
