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

		//user playing the actual game
		while(true){
            System.out.println(words.barScreen());
			//print out the map
            map.print();
			//print out the players stats
			System.out.println("HP: "+ player.getHealth()+ "\n" + "GP: " + player.getGold());

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
            // See if room has been visited (After this block we assume we are
            // in a new room)
            System.out.println(words.openRoom());
            if ( map.hasVisited() ) {
                System.out.println(words.oldRoom());
                continue;
            }

			//see if there is a monster,gold, or healing elixir in the room
            int roomType = rand.nextInt(3);
            //if gold or health add to total
            if ( roomType == 0 ) {
                // Health potion
                int health = rand.nextInt(5)+1;
                player.onHeal(health);
                System.out.println(words.healMsg(health));
            } else if ( roomType == 1 ) {
                // Loot gold
                int loot = 5 + rand.nextInt(26);
                player.onLoot(loot);
                System.out.println(words.lootMsg(loot));
            } else {
                // Battle Monster
                Monster enemy = getMonster();
                System.out.println(words.monsterAppears(enemy.toString()) );
                while (true) {
                    // Player action phase
                    String action = validateAction();
                    if (action.equalsIgnoreCase("a")) {
                        int eDmg = enemy.attack(player);
                        int pDmg = player.attack(enemy);
                        System.out.println(words.monsterHitMsg(enemy.toString(), eDmg));
                        System.out.println(words.playerHitMsg(enemy.toString(), pDmg));
                    } else {
                        int eDmg = enemy.attack(player);
                        System.out.println(words.playerEscapeMsg(enemy.toString(), eDmg));
                        break;
                    }

                    // Check to see if battle is over
                    if (player.isAlive()==false) {
                        break;
                    } else if (enemy.isAlive()==false) {
                        System.out.println(words.monsterDeathMsg(enemy.toString()));
                        break;
                    }
                    System.out.println("HP: "+ player.getHealth());
                }
            }

            // Check Endgame conditions
            if (player.isAlive()==false) {
                // Lose
                System.out.println(words.getLose());
                break;
            } else if (player.getGold() >= 100) {
                // Win
                System.out.println(words.getWin());
                break;
            }

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

	public String validateAction(){
		String action="";
		while(true){
			System.out.println(words.actionSelect());
			action=Scan();

			if(action.equalsIgnoreCase("A") || action.equalsIgnoreCase("R")){
				return action.toUpperCase();
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

	//Creates a random Monster
	public Monster getMonster(){
		int x= rand.nextInt(4);
		String[] monsters = {"GOBLIN","ORC","DENEKE","ZOMBIE"};
		Monster m = new Monster(monsters[x]);
        return m;
	}
}
