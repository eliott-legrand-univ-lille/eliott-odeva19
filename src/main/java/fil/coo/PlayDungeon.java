package fil.coo;

import fil.coo.util.*;
import fil.coo.adventuregame.*;

public class PlayDungeon {

	
	private Room createDungeon(){
		Room r1 = new Room();
		Room r2 = new Room();
		Room r3 = new Room();
		Room r4 = new Room();
		Room r5 = new Room(true);
		
		Monster m1 = new Monster(r2,"Rick",5,5,100);
		Monster m2 = new Monster(r5,"Morty",20,20,0);
		
		r1.addNeighboors(Direction.WEST, r2);
		r1.addNeighboors(Direction.SOUTH, r3);
		r1.addNeighboors(Direction.EAST, r4);
		r4.addNeighboors(Direction.EAST, r5);
		
		AdventureGame game = new AdventureGame(r1);
		
		game.addItem(new StrengthPotion(10), r2);
		game.addItem(new LifePotion(50), r3);
		game.addItem(new Gold(50), r4);
		game.addItem(new OneArmedBandit(10), r1);
		
		return r1;
		
	}
	
	
	public static void main(String[] args) {

		AdventureGame game = new AdventureGame(new PlayDungeon().createDungeon());
		Player p = new Player(game.currentRoom(),args[0],10,10,10);
		game.play(p);
		
		
	}	
	

}
