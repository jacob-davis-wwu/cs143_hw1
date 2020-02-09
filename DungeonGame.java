import java.util.*;
public class DungeonGame {
    private DungeonMap map;
    private Player player;

    public static String play() {
		System.out.println("You are in the Dungeon!! There are monsters,bags of gold, and healing elixirs in each room. Can you find 100 gold pieces and pay the evil professor to let you out before the monsters kill you?");

		//player selects class and checking to make sure it is either a 't' or 'w'
		boolean stat=true;
		while(stat){

			System.out.println("Select your Class:");
			System.out.println("Warrior: 'W'");
			System.out.println("Thief: 'T'");
			String ply=Scan();
			
			if(ply.equalsIgnoreCase("t") || ply.equalsIgnoreCase("W")){
				stat=false;
				
			}else{
				System.out.println("That was not an option. Try Again.");
			}
		}

		//setting the players stats bassed on class
		//Player player= new Player(ply);

		//
		
		
		return "ok";
    }
	public static String Scan(){

		//going to look for next character input from player and return to main method
		Scanner input= new Scanner(System.in);
		String cha= input.next().charAt(0);
		
		return cha;
	}
	public static void main(String[] args){
		String pl=play();
		return;
	}
}
