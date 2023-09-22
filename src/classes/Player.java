package classes;

public class Player extends Creature{
    int healingLeft;
    public Player(int attack, int defence, int minDamage, int maxDamage) {
        super(attack, defence, minDamage, maxDamage);
        healingLeft = 4;
    }

    public void heal() {
        if(isAlive() && couldHeal()) {
            raiseHealth(0.3);
            healingLeft--;
        }
    }

    private boolean couldHeal() {
        return healingLeft > 0;
    }
}
