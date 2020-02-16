import java.util.*;
import java.util.Random; 

public class Room {
    private boolean visited;
    private String roomType;
    private int heal;
    private int gold;

<<<<<<< HEAD

    public Room(String roomT) {
=======
    public Room() {
    	int randInt = (int) Math.floor(Math.random() * 3);
>>>>>>> 9ae27940dd2cae126d2482665fe9b4cdebc3520f
    	visited = false;
		Random rand= new Random();
		int x= rand.nextInt(16);
		System.out.println("here");

		if(roomT.equals("Gold")) {
			
			this.heal = 0;
			this.gold=x;
			this.roomType=("Gold");

		}else if(roomT.equals("Heal")){
			this.heal = x;
			this.gold = 0;
			this.roomType = "Heal";

		}else if(roomT.equals("Monster")) {
			this.heal = 0;
			this.gold = 0;
			this.roomType = "Monster";
		}

    }
    public void enter() {
    	visited = true;
    }

    public boolean hasVisited() {
        return this.visited;
    }
    public int getHeal() {
        return this.heal;
    }
    public int getGold() {
        return this.gold;
    }
}
