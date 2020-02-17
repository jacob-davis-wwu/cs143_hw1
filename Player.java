
public class Player {
    private int health;
    private int gold;
    private int damage;
    private String playerClass;
    private double lootModifier;
    private boolean isAlive;

    public Player(String playerClass) {
        playerClass = playerClass.toUpperCase();
        this.playerClass = playerClass;
        this.gold = 0;
        this.isAlive = true;

        if ( playerClass.equalsIgnoreCase("w")){
            health = 100;
            damage = 15;
            lootModifier = 1;
        } else if (playerClass.equalsIgnoreCase("t")){
            health = 70;
            damage = 10;
            lootModifier = 1.2;
        }
    }

    public int attack(Monster target) {
        // calls monster <target>'s onHit method for the players damage
        target.onHit(this.damage);
        return this.damage;
    }

    public void onHit(int damage) {
        // decreases player health by (damage>
        this.health -= damage;
        if (this.health <=0) {
            this.isAlive = false;
            this.health = 0;
        }
    }

    public void onHeal(int health) {
        // increases player health by <health>
        this.health += health;
        // Max health for each class
        if ( playerClass.equalsIgnoreCase("w") && health > 100){
            health = 100;
        } else if (playerClass.equalsIgnoreCase("t") && health > 70){
            health = 70;
        }
    }

    public void onLoot(int gold) {
        // increases player gold by <gold>
        this.gold += gold;
    }

    // Getters & Setters
    public int getHealth() {
        return this.health;
    }

    public void setHealth(int newHealth) {
        health = newHealth;
    }

    public int getGold() {
        return this.gold;
    }

    public void setGold(int newGold) {
        health = newGold;
    }

    public String getPlayerClass() {
        return this.playerClass;
    }

    public void setPlayerClass(String className) {
        this.playerClass = className;
    }

    public boolean isAlive() {
        if (this.isAlive) { return true; } else { return false; }
    }
}
