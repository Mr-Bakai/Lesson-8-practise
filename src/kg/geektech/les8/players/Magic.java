package kg.geektech.les8.players;

import java.util.Random;

public class Magic  extends  Hero{
    public Magic (int health, int damage){
        super(health, damage, SuperAbility.BOOST);
    }

    @Override

    public void applySuperAbility(Boss boss, Hero[] heroes){

        //  Random r = new Random();
        //        int  boost;
        //        boost = r.nextInt(15) + 5;
        System.out.println("-----------------------------------");
        for (int i = 0; i < heroes.length; i++) {
            Random g = new Random();
            int boost;
            boost = g.nextInt(2) + 5;
          if(heroes[i] != heroes[6] && heroes[i].getHealth() > 0){        // it doesn't let give a boost to Witcher
              heroes[i].setDamage( heroes[i].getDamage() + boost);
            System.out.println("Magic has boosted " + heroes[i].getClass().getSimpleName() + "'s damage for " + boost);
          }
        }
    }
}
/* Magic должен увеличивать атаку каждого
героя после каждого раунда на n-ное количество
 */



// Magic should not boost itself