import java.util.*;
import java.util.Random;
public class DungeonGame {
    private DungeonMap map;
    private Player player;
    private Messages words = new Messages();
    private Random rand = new Random();

    public void play() {
		System.out.println(words.getIntro());

		//player selects class under validateClass method
		String playerClass=validateClass();


		//setting the players stats bassed on class
		player= new Player(playerClass);
        map = new DungeonMap(player);
		System.out.println(words.barScreen());

		//user playing the actual game
		while(true){

			//print out the map
            map.print();
			//print out the players stats
			System.out.println("Health: "+ player.getHealth()+ "\n" + "Gold: " + player.getGold());

			//user selects what direction they want to go
            while (true) {
                String direct=direction();
                if (direct.equalsIgnoreCase("w") ) {
                    if ( map.moveUp() ) {
                        break;
                    } else {
                        System.out.println(words.wall());
                    }
                } else if (direct.equalsIgnoreCase("a")) {
                    if ( map.moveLeft() ) {
                        break;
                    } else {
                        System.out.println(words.wall());
                    }
                } else if (direct.equalsIgnoreCase("s")) {
                    if ( map.moveDown() ) {
                        break;
                    } else {
                        System.out.println(words.wall());
                    }
                } else if (direct.equalsIgnoreCase("d")) {
                    if ( map.moveRight() ) {
                        break;
                    } else {
                        System.out.println(words.wall());
                    }
                }
            }
			//see if there is a monster,gold, or healing elixir in the room
			//if monster see if the user wants to attack or run
			// break;
		}
    }

	public static String Scan(){

		//going to look for next input from user
		Scanner input= new Scanner(System.in);
		String cha= input.next();

		return cha;
	}

	//makes sure that the user input either a 't' or 'w'
	public String validateClass(){
		String ply="";
		while(true){
			System.out.println(words.classSelect());
			ply=Scan();

			if(ply.equalsIgnoreCase("t") || ply.equalsIgnoreCase("W")){
				return ply.toUpperCase();
			}else{
				System.out.println("That was not an option. Try Again.");
			}
		}
	}

	public String direction(){
		String d="";
		while(true){
			System.out.println(words.doorSelect());
			d=Scan();

			if(d.equalsIgnoreCase("w") || d.equalsIgnoreCase("s") || d.equalsIgnoreCase("a") || d.equalsIgnoreCase("d")){
				return d.toUpperCase();
			}else{
				System.out.println("That was not an option. Try Again.");
			}
		}
	}

    // Room type should be decided on entering unvisited room, so this code
    // isn't actually necessary
    //
	//gets the type of room and implements action depending on the type
	// public void getRoomType(){
	//
	// 	//Randomly chooses room type
	// 	int x= rand.nextInt(3);
	// 	//int x=2;
	// 	String[] rooms={"Gold","Heal","Monster"};
	// 	Room r= new Room(rooms[x]);
	// 	System.out.println("room: "+ rooms[x]+x);
	//
	// 	//Implement action based on room
	// 	Player p=player;
	// 	if(rooms[x].equals("Gold")){
	// 		//give gold to player
	// 		int g=r.getGold();
	// 		p.onLoot(g);
	//
    //
    //
	// 	}else if(rooms[x].equals("Heal")){
	// 		//heal player
	// 		int h=r.getHeal();
	// 		//checks health doesn't go over 100
	// 		if((p.getHealth()+h)>=100){
	// 			p.setHealth(100);
	// 		}else{
	// 			p.onHeal(h);
	// 		}
	//
    //
	// 	}else if(rooms[x].equals("Monster")){
	// 		//implement getMonster
	// 		getMonster();
	// 	}
	//
    //
	// }
	//Creates a random Monster
	public void getMonster(){
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
