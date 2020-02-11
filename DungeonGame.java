import java.util.*;
public class DungeonGame {
    private DungeonMap map;
    private Player player;

    public void play() {
		Messages words= new Messages();
		System.out.println(words.getIntro());

		//player selects class under validateClass method
		String playerClass=validateClass();


		//setting the players stats bassed on class
		Player player= new Player(playerClass);
		System.out.println(words.barScreen());

		//user playing the actual game
		while(true){
			//print out the map
			//print out the players stats
			System.out.println("Health: "+ player.getHealth()+ "\n" + "Gold: " + player.getGold());

			//user selects what direction they want to go
			String direct=direction();

			//see if there is a monster,gold, or healing elixir in the room

			//if monster see if the user wants to attack or run

			break;

		}

		
		
    } 
	public static String Scan(){

		//going to look for next input from user
		Scanner input= new Scanner(System.in);
		String cha= input.next();
		
		return cha;
	}

	//makes sure that the user input either a 't' or 'w'
	public static String validateClass(){
		Messages words= new Messages();
		String ply="";
		while(true){
			System.out.println(words.classSelect());
			ply=Scan();

			if(ply.equalsIgnoreCase("t") || ply.equalsIgnoreCase("W")){
				break;
				
			}else{
				System.out.println("That was not an option. Try Again.");
			}
		}
		return ply;
		
	}

	public static String direction(){
		Messages words= new Messages();
		String d="";
		while(true){
			System.out.println(words.doorSelect());
			d=Scan();

			if(d.equalsIgnoreCase("w") || d.equalsIgnoreCase("s") || d.equalsIgnoreCase("a") || d.equalsIgnoreCase("d")){
			//see if the user has already been to this room/see if they are trying to go through a wall
				System.out.println(words.openRoom());
				break;
			}else{
				System.out.println("That was not an option. Try Again.");
			}
		}

		return d;
		

	}
	 
}
