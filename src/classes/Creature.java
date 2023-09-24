package classes;

import java.util.Random;

public abstract class Creature {
    public static final int maxHealth = 100;
    private final int attack;
    private final int defence;
    protected int health;
    private final int minDamage;
    private final int maxDamage;

    public Creature(int attack, int defence, int minDamage, int maxDamage) {
        if(!isCorrectAttackValue(attack))
            throw new IllegalArgumentException("Incorrect attack value");
        if(!isCorrectDefenceValue(defence))
            throw new IllegalArgumentException("Incorrect defence value");
        if(!isCorrectDamageRange(minDamage, maxDamage))
            throw new IllegalArgumentException("Incorrect damage range");
        this.attack = attack;
        this.defence = defence;
        health = maxHealth;
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
    }

    private boolean isCorrectAttackValue(int value) {
        return value >= 1 && value <= 30;
    }

    private boolean isCorrectDefenceValue(int value) {
        return value >= 1 && value <= 30;
    }

    private boolean isCorrectDamageRange(int minDamage, int maxDamage) {
        return minDamage > 0 && maxDamage > 0 && minDamage < maxDamage;
    }

    public void hitOnSuccess(Creature creature) {
        if(creature == null)
            throw new NullPointerException("Creature should be non null");
        if(isAlive()) {
            int attackModifier = attack - creature.defence + 1;
            if (isSuccessfulHit(attackModifier)) {
                hit(creature);
            }
        }
    }

    public boolean isAlive() {
        return health > 0;
    }

    private boolean isSuccessfulHit(int attackModifier) {
        int rollsNumber = attackModifier>0 ? attackModifier : 1;
        for(int i = 0; i < rollsNumber; i++) {
            int number = rollDice();
            if(isSuccessfulRoll(number)) {
                return true;
            }
        }
        return false;
    }

    private int rollDice() {
        return new Random().nextInt(6) + 1;
    }

    private boolean isSuccessfulRoll(int number) {
        return number >= 5;
    }

    private void hit(Creature creature) {
        int damage = randomDamage();
        creature.health = Math.max(creature.health-damage,0);
    }

    private int randomDamage() {
        return new Random().nextInt(minDamage, maxDamage+1);
    }

    public int getHealth() {
        return health;
    }
}
