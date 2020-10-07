package kg.geektech.les8.players;

import java.util.Random;

public class Hunter extends Hero {
    public Hunter( int health, int damage){
     super(health, damage, SuperAbility.SAVE_DAMAGE_AND_REVERT);
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes){
        Random r = new Random();
        int savedDamage = r.nextInt(15) + 6;
        boss.setHealth(boss.getHealth() - savedDamage);
        this.setHealth(this.getHealth() + savedDamage);
        System.out.println("Hunter saved and reverted " + savedDamage);

    }
}
/* Hunter должен получать от босса
   урон, и потом наносить ему свой
   урон + часть урона полученного
   от босса
 */

