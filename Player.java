
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
}
