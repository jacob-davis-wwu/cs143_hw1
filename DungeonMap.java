
public class DungeonMap {
    private Room[][] rooms;
    private Player player;

    public DungeonMap (int rows, int columns, Player playerV){
    	player = playerV;
    	for (int i = 0; i < rows; i++) {
    		for (int j = 0; j < columns; j++){
    			rooms[i][j] = new Room();
    		}
    	}
    }

    public void print() {

    }
}
