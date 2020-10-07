package kg.geektech.les8.players;

public class Boss  extends  GameEntity {
    private boolean isStunned;

    public Boss(int health, int damage) {
        super(health, damage);
    }

    public boolean isStunned() {// wwww
        return isStunned;
    }

    public void setStunned(boolean stunned) {
        isStunned = stunned;
    }
}

