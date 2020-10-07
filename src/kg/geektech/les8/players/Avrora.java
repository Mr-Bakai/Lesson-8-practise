package kg.geektech.les8.players;

import java.util.Random;

public class Avrora extends Hero implements HavingSuperAbility {
    int counter;


    public Avrora(int health, int damage) {
        super(health, damage, SuperAbility.AVRORAS_SKILL);
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {
        Random r = new Random();
        int num = r.nextInt(2);
        if (num == 1) {
            System.out.println("------------------------------------");
            System.out.println("Avrora goes into invisible");
            if(counter == 50){
                System.out.println("Avrora is still in invisible in second round");
            }

            for (int i = 0; i < heroes.length; i++) {
                if (this == heroes[i] && heroes[i].getHealth() > 0) {
                    counter = counter + boss.getDamage();
                }
            }
        }
        if (num == 0 && counter == 50) {
            System.out.println("-------------------------------------------");
            System.out.println("Avrora goes into invisible for second round");

            for (int i = 0; i < heroes.length; i++) {
                if (this == heroes[i] && heroes[i].getHealth() > 0) {
                    counter = counter + boss.getDamage();
                }
            }
        }
        System.out.println("Accumulated damage while Avrora is in invisible " + counter);
        if (counter == 100) {
            setHealth(getHealth() + counter);
            boss.setHealth(boss.getHealth() - counter);
            System.out.println("Avrora is visible now and hits the Boss with  " + counter + " " + "Damage" +
                    "\nand by random will go into invisible again" );
            counter = 0;
        }
    }
}
/* Создать героя Avrora, которая
   может входить в режим невидимости
   на 2 раунда (т.е не получает урон от босса),
   в тоже время полученный урон в режиме
   невидимости возвращает боссу в последующих
   раундах
 */


// TASK 1 : Make Avrora go into invisible by random  ✔️
// TASK 2 : Make Avrora be in invisible for 2 rounds  ✔️
// TASK 3 : Make her hit boss once she is out of invisibility with the dage of collected while she was invisible ✔️