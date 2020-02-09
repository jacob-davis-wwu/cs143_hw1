
public class Player {
    private int health;
    private int gold;
    private int damage;
    private String playerClass;
    private double lootModifier;

    public void attack(Monster target) {

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
