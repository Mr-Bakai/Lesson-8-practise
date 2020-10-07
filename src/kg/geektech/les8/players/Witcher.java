package kg.geektech.les8.players;

public class Witcher extends Hero {

    public Witcher(int health, int damage) {
        super(health, damage, SuperAbility.REVIVE_SMN);
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if(this != heroes[i] && heroes[i].getHealth() <= 0){
               heroes[i].setHealth(heroes[i].getHealth() + getHealth());
                System.out.println("---------------------------------");
                System.out.println("Witcher has given her  health: " + getHealth() + " to "
                        + heroes[i].getClass().getSimpleName());
                setHealth(0);
                break;
            }
        }
    }
}


/* Добавить еще игрока Witcher,
не наносит урон боссу, но получает урон от босса.
 Имеет 1 шанс оживить первого погибшего героя,
 отдав ему свою жизнь, при этом погибает сам.
 */