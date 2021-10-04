package Taski.hero;

public class TrainingGround {
    public static void main(String[] args) {
        Hero warrior = new Warrior("Petya", 20);
        Hero mage = new Mage("Vasya", 10);
        Hero archer = new Archer("Tolya", 15);
        Enemy enemy = new Enemy("Зомби", 100);
        attackEnemy(enemy, mage, archer, warrior);

    }

    public static void attackEnemy(Enemy enemy, Hero... heroes) {
        while (enemy.isAlive()) {
            for (Hero hero : heroes) {
                if (enemy.isAlive()) {
                    hero.attackEnemy(enemy);
                }
            }
        }
    }
}
