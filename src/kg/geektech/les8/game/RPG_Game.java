package kg.geektech.les8.game;

import kg.geektech.les8.players.*;

public class RPG_Game {

    public static void start() {
        Boss boss = new Boss(2000, 50);
        Warrior warrior = new Warrior(250, 15);
        Hunter hunter = new Hunter(260, 10);
        Medic doctor = new Medic(230, 10, 15, "Older doc");
        Magic magic = new Magic(100, 20);
        Medic youngDoctor = new Medic(100, 20, 5, "Young Doc");
        Thor thor = new Thor(100, 20);
        Witcher witcher = new Witcher(400, 0);
        Tank tank = new Tank(500, 5);
        Avrora avrora = new Avrora(200, 10);

        Hero[] heroes = {warrior, hunter, doctor, magic, youngDoctor, thor, witcher, tank, avrora};

        printStatistics(boss, heroes);

        while (!isGameFinished(boss, heroes)) {
            round(boss, heroes);
        }
    }

    private static void round(Boss boss, Hero[] heroes) {
        heroesHit(boss, heroes);
        if (boss.getHealth() > 0 && !boss.isStunned()) { //www
            bossHits(boss, heroes);
        }
        applySuper(boss, heroes);
        printStatistics(boss, heroes);
    }

    public static void printStatistics(Boss boss, Hero[] heroes) {
        System.out.println("-------------------------------------");
        System.out.println("Boss health:   " + boss.getHealth());
        for (int i = 0; i < heroes.length; i++) {
            System.out.println(heroes[i].getClass().getSimpleName()
                    + " Health: " + heroes[i].getHealth());
        }
        System.out.println("-------------------------------------");
    }

    private static boolean isGameFinished(Boss boss, Hero[] heroes) {
        if (boss.getHealth() <= 0) {
            System.out.println("Heroes won!!! You son of a biiiiiiiishkek");
            return true;
        }

        boolean allHeroIsDead = true;
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {
                allHeroIsDead = false;
                break;
            }
        }

        if (allHeroIsDead) {
            System.out.println("Your DaddyBoss won!!!");
        }
        return allHeroIsDead;
    }


   /* public static void bossHits(Boss boss, Hero[] heroes) {
        int count = 0;
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i] == heroes[8] && heroes[i].getHealth() > 0) {
                boss.setDamage(0);
                System.out.println("Avrora went invisible " + boss.getDamage());
                count = count + 1;
                System.out.println(count);
            }else{
                boss.setDamage(50);
                heroes[i].setHealth(heroes[i].getHealth() - boss.getDamage());
            }
        }
    }*/

    public static void bossHits(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {
                heroes[i].setHealth(heroes[i].getHealth() - boss.getDamage());
            }
        }
    }

    public static void heroesHit(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (boss.getHealth() > 0 && heroes[i].getHealth() > 0) {
                boss.setHealth(boss.getHealth() - heroes[i].getDamage());
            }
        }
    }

    private static void applySuper(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {
                heroes[i].applySuperAbility(boss, heroes);
            }
        }
    }
}
