package Taski.hero;

import Taski.hero.weapon.MeleeWeapon;

public class Warrior<T extends MeleeWeapon> extends Hero<T> {


    public Warrior(String name, int damage) {
        super(name, damage);
    }

    @Override
    public void attackEnemy(Enemy enemy) {
        System.out.println(getName() + " стреляю из базуки в " + enemy.getName());
        enemy.takeDamage(getDamage());
    }
}
