
import java.util.*;
public class Monster {
	/*
	 * This is the main Monster Class. This class contains the 
	 * settings and controls for the different types of monsters
	 * that the player will be fighting.
	 * */
    private int health;
    private int damage;
    private String monsterType;
    private String name;

    public Monster(String monsterVar) {
    	monsterVar.toUpperCase();
    	if(monsterVar.equals("ORC")) {
    		this.health = 18;
    		this.damage = 20;
    		this.name = "Orc";
    	}
    	else if(monsterVar.equals("GOBLIN")){
    		this.health = 6;
    		this.damage = 10;
    		this.name = "Goblin";
    	}
    	else if(monsterVar.equals("ZOMBIE")) {
    		this.health = 12;
    		this.damage = 15;
    		this.name = "Zombie";
    	}
    	else if(monsterVar.equals("DENEKE")){
    		this.health = 55;
    		this.damage = 5;
    		this.name = "Deneke";
    	}
    	else {
    		this.damage = 0;
    		this.health = 0;
    		this.name = "";
    	}
    }
    public void attack(Player target) {
    	target.onHit(this.damage);
    }

    public void onHit(int damage) {
    	this.health -= randDamage(damage);
    }
    public String toString() {
    	return this.name;
    }
    public void main(String[] args) {
    	Monster orc1 = new Monster("Orc");
    	System.out.println(orc1);
    }
    public int randDamage (int range) {
    	int value = (int)((Math.random() * range) + 1);
    	return value;
    }
    
}
