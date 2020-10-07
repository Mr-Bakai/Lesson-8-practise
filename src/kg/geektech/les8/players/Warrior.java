package kg.geektech.les8.players;

import java.util.Random;

public class Warrior extends Hero {

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {
        Random critical = new Random();
        int criticalDamage = critical.nextInt(5); // we have to get random number in range 2 to 4

        if (criticalDamage == 0) {
            criticalDamage = criticalDamage + 2;
        } else if (criticalDamage == 1) {
            criticalDamage = criticalDamage + 1;
        }

        boss.setHealth(boss.getHealth() - (getDamage() * criticalDamage));
        System.out.println("Warrior has got CRITICAL DAMAGE  " + getDamage() * criticalDamage );

    }


    public Warrior(int health, int damage) {
        super(health, damage, SuperAbility.CRITICAL_DAMAGE);
    }
}
/* Warrior каждый раз при атаке
   критует. Т.е. каждая атака
   умножается на случайное число от 2 до 4.
 */