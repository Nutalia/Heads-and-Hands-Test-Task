package test;

import classes.Monster;
import classes.Player;

public class Main {
    public static void main(String[] args) {
	    Monster monster = new Monster(30, 15, 10, 20);
        Player player = new Player(20, 10, 5, 10);
        while(monster.isAlive() && player.isAlive()) {
            player.hitOnSuccess(monster);
            monster.hitOnSuccess(player);
            if(player.getHealth() < (int)(0.5* Player.maxHealth)) {
                player.heal();
            }
        }
        if(monster.isAlive()) {
            System.out.println("Monster won");
        } else {
            System.out.println("Player won");
        }
    }
}
