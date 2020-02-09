
public class Player {
    private int health;
    private int gold;
    private int damage;
    private String playerClass;
    private double lootModifier;

    public Player(String playerClass) {
        playerClass = playerClass.toUpperCase();
        this.playerClass = playerClass;
        this.gold = 0;

        if ( playerClass == "WARRIOR" ) {
            health = 100;
            damage = 15;
            lootModifier = 1;
        } else if (playerClass == "THIEF") {
            health = 70;
            damage = 10;
            lootModifier = 1.2;
        }
    }

    public void attack(Monster target) {
        // calls monster <target>'s onHit method for the players damage
        target.onHit(this.damage);
    }

    public void onHit(int damage) {
        // decreases player health by (damage>
        this.health -= damage;

    }

    public void onHeal(int health) {
        // increases player health by <health>
        this.health += health;
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
}
