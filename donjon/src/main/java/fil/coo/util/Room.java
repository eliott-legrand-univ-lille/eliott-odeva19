package fil.coo.util;

import java.util.*;

import fil.coo.adventuregame.*;


/**
 * <b> Class that represent a Room </b>
 * 
 *  <p>A Room is defined by :</p>
 *  <ul> 
 *  <li>His Items</li>
 *  <li>His Neighbors</li>
 *  </ul>
 * 
 *  <p> Moreover a Room can be an exit </p>
 * 
 * @author legrand,santi
 *
 */
public class Room {
	
	protected List<Item> items;
	protected Map<Direction,Room> neighbors;
	protected List<Monster> monsters;
	protected boolean exit;
	
	public Room(boolean exit) {
		this.exit = exit;
		this.items = new ArrayList<Item>() ;
		this.monsters= new ArrayList<Monster>() ;
		this.neighbors= new HashMap<Direction,Room>() ;
	}
	
	public Room() {
		this(false);
	}

	/** 
	 * Add a Monster to the Room
	 * @param m the monster to add to the room
	 */
	public void addMonster(Monster m) {
		this.monsters.add(m);
		if (!m.currentRoom.equals(this)) {
			m.setActualRoom(this);
		}
	}

	/** 
	 * Remove a Monster from the Room
	 * @param m the monster to remove from the room
	 */
	public void removeMonster(Monster m) {
		this.monsters.remove(m);
	}

	/** 
	 * The monster in the room
	 * @return the list of Monster in the room
	 */
	public List<Monster> getMonsters(){
		return this.monsters;
	}
	
	/** 
	 * Return the direction available in this Room
	 * @return the direction possible from this room
	 */
	public Set<Direction> getPossibleDirection(){
		return this.neighbors.keySet();
	}
	
	/** 
	 * Say if the room is an exit
	 * @return true if the room is an exit, else false
	 */
	public boolean isExit() {
		return this.exit;
	}

	/** 
	 * Allow to add a Room and a Direction associated
	 * If the direction was already taken the new Room replace the old
	 * @param d the direction who lead to the Room r
	 * @param r the Room the Direction d
	 */
	public void addNeighboors(Direction d,Room r) {
		this.neighbors.put(d,r);
		r.neighbors.put(d.getOpposite(),this);
	}

	
	/** 
	 * Return the Room associated with Direction d or null if there are no room in this direction
	 * @param d the direction to acceed the neighbor
	 * @return the Room at the direction d 
	 */
	public Room getNeighboor(Direction d) {
		return this.neighbors.get(d);
	}

	/** 
	 * The items in the room
	 * @return the list of the rooms's item
	 */
	public List<Item> getItems() {
		return items;
	}

	/** 
	 * Add an item in the room
	 * @param item the item to add
	 */
	public void addItems(Item item) {
		this.items.add(item);
	}
	
	/** 
	 * Remove an item from the room
	 * @param item the item to remove 
	 */
	public void removeItems(Item item){
		this.items.remove(item);
		
	}

	public String getDescription() {
		String res="This room contains :\n";
		for (Item i : this.items) {
			res+=" "+i.getDescription()+"\n";
		}
		for (Monster m : this.monsters) {
			res+=" "+m.getDescription()+"\n";
		}
		res+="You can go to ";
		for (Direction d : this.getPossibleDirection()) {
			res+=d.name()+" ";
		}
		return res;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (exit ? 1231 : 1237);
		result = prime * result + ((items == null) ? 0 : items.hashCode());
		result = prime * result + ((monsters == null) ? 0 : monsters.hashCode());
		result = prime * result + ((neighbors == null) ? 0 : neighbors.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Room other = (Room) obj;
		if (exit != other.exit)
			return false;
		if (items == null) {
			if (other.items != null)
				return false;
		} else if (!items.equals(other.items))
			return false;
		if (monsters == null) {
			if (other.monsters != null)
				return false;
		} else if (!monsters.equals(other.monsters))
			return false;
		if (neighbors == null) {
			if (other.neighbors != null)
				return false;
		} else if (!neighbors.equals(other.neighbors))
			return false;
		return true;
	}
	
	public static void main(String[] args) {
		Room r1 = new Room();
		Room r2 = new Room();
		Room r3 = new Room();
		Monster m = new Monster(r1,"Leïla");
		Player p = new Player(r1,"Luc");
		Gold purse = new Gold(10);
		LifePotion lifePotion = new LifePotion(10);
		
		m.addGold(100);
		r1.addNeighboors(Direction.SOUTH, r2);
		r1.addNeighboors(Direction.NORTH, r3);
		r1.addItems(purse);
		r1.addItems(lifePotion);
		p.act();
		
		
	}
}
