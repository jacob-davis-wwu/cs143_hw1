
public class Messages {
    // Container for all long text srings that might need to be displayed
    // as well as some modular strings for interactions with monsters

    private static final String INTRO = "You are in a dungeon!\n" +
        "There are monsters, bags of gold, or healing elixers in each room.\n" +
        "Can you find 100 gold pieces and pay the evil professor to let you out before the monster kill you?";
    private static final String RUN = "You try to run...";
    private static final String WALL = "You can't move through a wall!";
    private static final String WIN = "You have succesfully navigated the dungeon. Congrats!";
    private static final String LOSE = "You died!";
    private static final String OLD_ROOM = "You have already visited this room.";
    private static final String OPEN = "You open a door and move though...";
    private static final String BAR = "====================================";
    private static final String CLASS_SELECT = "Select your class:\n[W]arrior\n[T]hief";
    private static final String DOOR_SELECT = "Select a door:\n[W] Up\n[A] Left\n[S]Down\n[D] Right";
    private static final String ACTION_SELECT = "Select an action:\n[1] Attack\n[2] Run";

    // Simple return functions
    public String getIntro() {
        return INTRO;
    }

    public String getWin() {
        return WIN;
    }

    public String getLose() {
        return LOSE;
    }

    public String wall() {
        return WALL;
    }

    public String run() {
        return RUN;
    }

    public String oldRoom() {
        return OLD_ROOM;
    }

    public String openRoom() {
        return OPEN;
    }

    public String barScreen() {
        return BAR;
    }

    public String classSelect() {
        return CLASS_SELECT;
    }

    public String doorSelect() {
        return DOOR_SELECT;
    }

    public String actionSelect() {
        return ACTION_SELECT;
    }

    // Status message
    public String statusMsg(int hp, int gp) {
        return "HP = " + hp +"\nGP = " + gp;
    }

    // These methods deal with monsters, and take information to build and
    // return a string
    public String monsterAppears(String monsterType) {
        return "A " + monsterType + " appears!";
    }

    public String monsterHitMsg(String monsterType, int damage) {
        return "The " + monsterType + "hits you for " + damage + " damage.";
    }

    public String playerHitMsg(String monsterType, int damage) {
        return "You hit the " + monsterType + " for " + damage +" damage!";
    }

    public String playerEscapeMsg(String monsterType, int damage) {
        return ("The " + monsterType + " hits you for " + damage +" damage as you escape!");
    }

    public String monsterDeathMsg(String monsterType) {
        return "The " + monsterType + " dies!";
    }

    public String lootMsg(int loot) {
        return "You find a bag of " + loot + " gold pieces!";
    }

    public String healMsg(int health) {
        return "You find a healing elixer and are healed for " + health + " hp!";
    }
}
