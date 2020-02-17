import java.util.*;
public class Main {
    private static final String inputErrorMsg = "Please only input two positive integers, nRows nCols, as arguments to this program and try again.";

    public static void main(String[] args) {
        // Starts game, either with a 10x10 dungeon map or a (nRows)x(nCols)
        // map if 2 integers > 0 as command line args
        DungeonGame game= new DungeonGame();
        int nRows = 10;
        int nCols = 10;
        if (args.length == 2) {
            // Make sure args are ints
            boolean run = true;
            try {
                nRows = Integer.parseInt(args[0]);
                nCols = Integer.parseInt(args[1]);
            } catch (NumberFormatException e) {
                run = false;
            }
            // Make sure args are positive
            if (nRows > 0 && nCols > 0 && run) {
                game.play(nRows,nCols);
            } else {
                System.out.println(inputErrorMsg);
            }
        // Run 10x10 if no args
        } else if (args.length == 0) {
            game.play(10,10);
        // Error message if other number of args
        } else {
            System.out.println(inputErrorMsg);
        }
    }
}
