package classes;

public class Player extends Creature{
    int healingLeft;
    public Player(int attack, int defence, int minDamage, int maxDamage) {
        super(attack, defence, minDamage, maxDamage);
        healingLeft = 4;
    }

    public void heal() {
        if(isAlive() && couldHeal()) {
            health = Math.min((int)Math.round(health + 0.3*maxHealth), maxHealth);
            healingLeft--;
        }
    }

    private boolean couldHeal() {
        return healingLeft > 0;
    }
}
