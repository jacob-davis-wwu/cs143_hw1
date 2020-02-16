import java.util.*;
import java.util.Random; 
public class DungeonGame {
    private DungeonMap map;
    private Player player;
  
    public void play() {
		Messages words= new Messages();
		System.out.println(words.getIntro());

		//player selects class under validateClass method
		String playerClass=validateClass();


		//setting the players stats bassed on class
		player= new Player(playerClass);
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

	public String direction(){
		Messages words= new Messages();
		String d="";
		while(true){
			System.out.println(words.doorSelect());
			d=Scan();

			if(d.equalsIgnoreCase("w") || d.equalsIgnoreCase("s") || d.equalsIgnoreCase("a") || d.equalsIgnoreCase("d")){
			//see if the user has already been to this room/see if they are trying to go through a wall
				System.out.println(words.openRoom());
				getRoomType();
				break;
			}else{
				System.out.println("That was not an option. Try Again.");
			}
		}

		return d;
		

	}
	
	//gets the type of room and implements action depending on the type
	public void getRoomType(){
		
		//Randomly chooses room type
		Random rand= new Random();
		int x= rand.nextInt(3);
		//int x=2;
		String[] rooms={"Gold","Heal","Monster"};
		Room r= new Room(rooms[x]);
		System.out.println("room: "+ rooms[x]+x);
		
		//Implement action based on room
		Player p=player;
		if(rooms[x].equals("Gold")){
			//give gold to player
			int g=r.getGold();
			p.onLoot(g);
			


		}else if(rooms[x].equals("Heal")){
			//heal player
			int h=r.getHeal();
			//checks health doesn't go over 100
			if((p.getHealth()+h)>=100){
				p.setHealth(100);
			}else{
				p.onHeal(h);
			}
			

		}else if(rooms[x].equals("Monster")){
			//implement getMonster
			getMonster();
		}
		

	}
	//Creates a random Monster
	public void getMonster(){
		Random rand= new Random();
		int x= rand.nextInt(4);
		String[] monsters = {"Goblin","Orc","Deneke","Zombie"};
		Monster m = new Monster(monsters[x]);
		System.out.println("monster: " + monsters[x] + x);
		attackPlayer(monsters[x]);
	}

	public void attackPlayer(String monster){
		System.out.println("A "+ monster+ " appears!!");
		while(true){
			Messages words= new Messages();
			System.out.println(words.actionSelect());
			String action=Scan();
			if(action.equals("1")){
				//fight monster
			}else if(action.equals("2")){
				//run from monster
				System.out.println(words.run());
				break;
			}else{
				System.out.println("That was not an option. Try Again.");
				
			}
		}
			

	}
	 
}
