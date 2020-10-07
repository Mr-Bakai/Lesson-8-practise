package kg.geektech.les8.players;

import java.util.Random;

public class Thor extends Hero implements HavingSuperAbility{

    public Thor(int health, int damage){
        super(health, damage, SuperAbility.SAVE_DAMAGE_AND_REVERT);
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {
        if(new Random().nextInt(2) == 1){
            System.out.println("-----------------------------------");
            System.out.println("Boss is Stunned for one round");
            boss.setStunned(true);

        } else {
            boss.setStunned(false);
        }
    }
}
/*Добавить еще игрока, Thor,
  удар по боссу имеет шанс оглушить
  босса на 1 раунд, вследствие чего
  босс пропускает 1 раунд и не наносит
  урон героям.
 */
