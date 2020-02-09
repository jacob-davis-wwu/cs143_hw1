
public class Messages {
    // Container for all long text srings that might need to be displayed
    private final String INTRO = "You are in a dungeon!\n" +
        "There are monsters, bags of gold, or healing elixers in each room.\n" +
        "Can you find 100 gold pieces and pay the evil professor to let you out before the monster kill you?";
    private final String RUN = "You try to run...";
    private final String WALL = "You can't move through a wall!";
    private final String WIN = "You have succesfully navigated the dungeon. Congrats!";
    private final String LOSE = "You died!";


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
}
