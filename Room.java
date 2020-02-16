
public class Room {
    private boolean visited;
    private String roomType;

    public Room() {
    	int randInt = (int) Math.floor(Math.random() * 3);
    	visited = false;
    	if(randInt == 0) {
    		this.roomType = "Gold";
    	}
    	else if(randInt == 1) {
    		this.roomType = "Heal";
    	}
    	else {
    		this.roomType = "Monster";
    	}
    }
    public void enter() {
    	visited = true;
    }

    public boolean hasVisited() {
        return this.visited;
    }
}
