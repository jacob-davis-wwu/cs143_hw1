
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
    private boolean isAlive;
    private Random rand = new Random();


    public Monster(){
        this.health = 0;
	this.damage = 0;
	this.name = "Null";
    }
    public Monster(String monsterVar) {
    	monsterVar.toUpperCase();
        this.isAlive = true;
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
    public int attack(Player target) {
        int dmg = rand.nextInt(this.damage);
    	target.onHit(dmg);
        return dmg;
    }

    public void onHit(int damage) {
    	this.health -= damage;
        if (this.health <= 0) {
            this.isAlive = false;
        }
    }
    public String toString() {
    	return this.name;
    }

    public void main(String[] args) {
    	Monster orc1 = new Monster("Orc");
    	System.out.println(orc1);
    }

    public boolean isAlive() {
        if (this.isAlive) {return true;} else {return false;}
    }
}
