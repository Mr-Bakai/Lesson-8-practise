package kg.geektech.les8.players;

public class Tank extends Hero implements HavingSuperAbility {

    public Tank(int health, int damage) {
        super(health, damage, SuperAbility.LIGHT_PROTECTION);
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {

        int aliveHero = 0;
        int savedDamage;
        for (int i = 0; i < heroes.length; i++) {
            if (this != heroes[i] && heroes[i].getHealth() > 0) {
                aliveHero = aliveHero + 1;
                heroes[i].setHealth(heroes[i].getHealth() + 10);
            }
        }
        savedDamage = aliveHero * 10;
        setHealth( getHealth() - savedDamage);
        System.out.println("Tank has protected in total: " + savedDamage);
    }
}

/*Добавить еще игрока, Tank, который
имеет увеличенную жизнь но слабый удар.
Может принимать на себя 1/5 часть урона
исходящего от босса по другим игрокам.
 */


