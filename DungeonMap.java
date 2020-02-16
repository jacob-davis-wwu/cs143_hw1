
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
                    row = row + "x";
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
