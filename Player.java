
public class Player {
    private int health;
    private int gold;
    private int damage;
    private String playerClass;
    private double lootModifier;

    public void attack(Monster target) {

    }

    public void onHit(int damage) {

    }

    public void onHeal(int health) {

    }

    public void onLoot(int gold) {

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

    public String getClass() {
        return this.playerClass
    }

    public void setClass(String className) {
        this.playerClass = className
    }
}
