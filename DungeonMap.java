
public class DungeonMap {
	//Variable Initialization
    private Room[][] rooms;
    private Player player;
    private int[] playerLocation = {0,0};
    private int rows;
    private int cols;
    private boolean isThief = false;

    //Constructor given rows and columns, else it is identical to the basic
    //constructor.
    public DungeonMap (int rows, int columns, Player playerV){
        this.rows = rows;
        this.cols = columns;
        Room[][] rooms = new Room[rows][cols];
    	for (int i = 0; i < rows; i++) {
    		for (int j = 0; j < columns; j++){
    			rooms[i][j] = new Room();
    		}
    	}
        this.rooms = rooms;

        String pClass = playerV.getPlayerClass();
        if (pClass.equalsIgnoreCase("t")) {
            isThief = true;
        }
    }
    
    //This is the constructor for the DungeonMap class
    //Sets the rows and columns to a value of 10
    //Creates a double array of rooms
    public DungeonMap (Player playerV) {
        this.rows = 10;
        this.cols = 10;
        Room[][] rooms = new Room[rows][cols];
    	for (int i = 0; i < rows; i++) {
    		for (int j = 0; j < cols; j++){
    			rooms[i][j] = new Room();
    		}
    	}
        this.rooms = rooms;

        String pClass = playerV.getPlayerClass();
        if (pClass.equalsIgnoreCase("t")) {
            isThief = true;
        }
    }

    // Moving the player
    // Each movement method returns a boolean based on whether or not it was
    // possible to move in the desired direction

    //Moves the player up on the map
    public boolean moveUp() {
        if ( playerLocation[0] != 0 ) {
            rooms[playerLocation[0]][playerLocation[1]].enter();
            playerLocation[0] -= 1;
            return true;
        } else {
            return false;
        }
    }
    
    //Moves the player down on the map
    public boolean moveDown() {
        if ( playerLocation[0] != rows - 1 ) {
            rooms[playerLocation[0]][playerLocation[1]].enter();
            playerLocation[0] += 1;
            return true;
        } else {
            return false;
        }
    }
    //Moves the player left on the map
    public boolean moveLeft() {
        if ( playerLocation[1] != 0 ) {
            rooms[playerLocation[0]][playerLocation[1]].enter();
            playerLocation[1] -= 1;
            return true;
        } else {
            return false;
        }
    }
    
    //Moves the player right on the map
    public boolean moveRight() {
        if ( playerLocation[1] != cols - 1 ) {
            rooms[playerLocation[0]][playerLocation[1]].enter();
            playerLocation[1] += 1;
            return true;
        } else {
            return false;
        }
    }

    // Printing the map

    public void print() {
        printWall(this.cols);
        for (int i=0; i < rows; i++) {
            String row = "|";
            for (int j=0; j < cols; j++) {
                if ( ( playerLocation[0] == i) && ( playerLocation[1] == j ) ) {
                    if (this.isThief) {
                        row = row + "T";
                    } else {
                        row = row + "W";
                    }
                } else if (rooms[i][j].hasVisited()) {
                    row = row + "*";
                } else {
                    row = row + " ";
                }
            }
            row = row + "|";
            System.out.println(row);
        }
        printWall(this.cols);
    }

    public void printWall(int cols) {
        String wall = "+";
        for(int i=0; i < cols; i++ ) {
           wall = wall + "-";
        }
        System.out.println(wall + "+");
    }

    public int getPlayerX() {
        return playerLocation[0];
    }
    public int getPlayerY() {
        return playerLocation[1];
    }

    public boolean hasVisited() {
        if (rooms[playerLocation[0]][playerLocation[1]].hasVisited() )
            { return true;}
            else { return false;}
    }
}
