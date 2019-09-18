package fil.coo.adventuregame;

import fil.coo.util.*;

/**
 * <b> An epic Adventure Game ! </b>
 * 
 * @author legrand,santi
 *
 */
public class AdventureGame {
	
	private Room currentRoom;
	private Player player;
	
	public AdventureGame(Room startingRoom) {
		this.currentRoom=startingRoom;
	}

	/**
	 * The current room in the game
	 * @return the current Room
	 */
	public Room currentRoom() {
		return currentRoom;
	}

	/**
	 *  The player in the game 
	 * @return the Player
	 */
	public Player getPlayer() {
		return this.player;
	}
	
	/**
	 *  Play the Dungeon Game !
	 * @param p The Player you want to play with
	 */
	public void play(Player p) {
		this.player=p;
		player.setActualRoom(this.currentRoom);
		while (!this.isFinished()) {
			this.currentRoom=p.getActualRoom();
			if (this.GameOver()) {
				System.out.println("You LOOSE !");
				break;
			}
			if (this.isFinished()) {
				System.out.println("You WIN !");
				break;
			}
			p.act();
		}
		if (this.isFinished()) {
			System.out.println("You WIN !");
		}
	
		
	}
	
	/** 
	 * Add monster to the game
	 * @param monster The Monster to add
	 * @param room The Room of the Monster
	 */
	public void addMonster(Monster monster,Room room) {
		room.addMonster(monster);
	}
	
	/** 
	 * Add item to the game 
	 * @param item The item to add
	 * @param room The Room of the item
	 */
	public void addItem(Item item,Room room) {
		room.addItems(item);
	}
	
	/** 
	 * If the game is finished
	 * @return True if the game is finished, else False
	 */
	boolean isFinished() {
		if (this.currentRoom.isExit() && this.currentRoom.getMonsters().isEmpty()) {
			return true;
		}
		return false;
	}
	
	/**
	 *  If it's Game Over
	 * @return True if it's GameOver, else false
	 * 
	 */
	boolean GameOver() {
		return player.isDead();
	}
	
	/*public static void main(String[] args) {
		Room r1 = new Room();
		Room r2 = new Room();
		Room r3 = new Room(true);
		Monster m = new Monster(r1,"Leïla",1,5,10);
		Player p = new Player(r1,"Luc",20,10,20);
		Gold purse = new Gold(10);
		LifePotion lifePotion = new LifePotion(10);
		m.addGold(100);
		r1.addNeighboors(Direction.SOUTH, r2);
		r1.addNeighboors(Direction.NORTH, r3);
		r1.addItems(purse);
		r1.addItems(lifePotion);
		AdventureGame game = new AdventureGame(r1);
		game.play(p);
	} */
}
