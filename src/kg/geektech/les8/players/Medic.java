package kg.geektech.les8.players;

public class Medic extends Hero {
    private int healPoints;
    private String name;

    public Medic(int health, int damage, int healPoints, String name) {
        super(health, damage, SuperAbility.HEAL);
        this.healPoints = healPoints;
        this.name = name;
    }

    @Override

    public void applySuperAbility(Boss boss, Hero[] heroes) {
        System.out.println("-----------------------------------");
        for (int i = 0; i < heroes.length; i++) {
            if (this != heroes[i] && heroes[i].getHealth() > 0) {
                heroes[i].setHealth(heroes[i].getHealth() + healPoints);
                System.out.println(heroes[i].getClass().getSimpleName() + " has been healed " + healPoints );
            }
        }
    }
}

