
public class DungeonMap {
    private Room[][] rooms;
    private Player player;
    private int[] playerLocation = {0,0};
    private int rows;
    private int cols;
    private boolean isThief = false;

    public DungeonMap (int rows, int columns, Player playerV){
        this.rows = rows;
        this.cols = columns;
    	for (int i = 0; i < rows; i++) {
    		for (int j = 0; j < columns; j++){
    			rooms[i][j] = new Room();
    		}
    	}

        String pClass = playerV.getPlayerClass();
        if (pClass.equalsIgnoreCase("t")) {
            isThief = true;
        }
    }

    // Moving the player
    // Each movement method returns a boolean based on whether or not it was
    // possible to move in the desired direction

    public boolean moveUp() {
        if ( playerLocation[1] != 0 ) {
            playerLocation[1] -= 1;
            return true;
        } else {
            return false;
        }
    }

    public boolean moveDown() {
        if ( playerLocation[1] != rows - 1 ) {
            playerLocation[1] += 1;
            return true;
        } else {
            return false;
        }
    }

    public boolean moveLeft() {
        if ( playerLocation[0] != 0 ) {
            playerLocation[0] -= 1;
            return true;
        } else {
            return false;
        }
    }

    public boolean moveRight() {
        if ( playerLocation[0] != cols - 1 ) {
            playerLocation[0] += 1;
            return true;
        } else {
            return false;
        }
    }

    // Printing the map

    public void print() {
        printWall(this.cols);
        for (i=0; i < rows; i++) {
            String row = "|";
            for (j=0; j < cols; j++) {
                if ( ( playerLocation[0] == i) && ( playerLocation[1] == j ) ) {
                    if (this.isThief) {
                        row = row + "T";
                    } else {
                        row = row + "W";
                    }
                } else if (rooms[i][j].hasVisited()) {
                    row = row + "*";
                } else {
                    row = row = " ";
                }
            }
            row = row + "|";
        }
        printWall(this.cols);
    }

    public void printWall(int cols) {
        String wall = "+";
        for(i=0; i < cols; i++ ) {
           wall = wall + "-";
        }
        System.out.println(wall + "+");
    }
}
