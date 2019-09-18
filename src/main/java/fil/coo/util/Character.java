package fil.coo.util;

/**
 *  <b>Abstract class that represent a Character</b>
 *  
 *  <p>A Character is defined by :</p>
 *  <ul> 
 *  <li>His life</li>
 *  <li>His strength</li>
 *  <li>His gold</li>
 *  <li>His current Room</li>
 *  <li>His name</li>
 *  </ul>
 *  <p> Moreover he can attack an other Character </p>
 *  
 * @see Room 
 * 
 * @author legrand,santi
 *
 */
public abstract class Character implements Chooseable {


	protected int life;
	protected int strength;
	protected int gold;
	protected Room currentRoom;
	protected String name;
	
	public Character(Room r,String name,int life,int strength,int gold) {
		this.currentRoom=r;
		this.life=life;
		this.gold=gold;
		this.strength=strength;
		this.name=name;
	}
	
	public Character(Room r,String name) {
		this(r,name,1,1,0);
	}
	
	/**
	 *  Return the life of the character
	 * @return the life of the character
	 */
	public int getLife() {
		return life;
	}

	/** 
	 * Add to the life of the character
	 * @param life the amount of life to add
	 */
	public void addLife(int life) {
		if (this.life+life<0){
			this.life=0;
		}
		else{
			this.life += life;
		}
	}

	/** 
	 * Return the strength of the character
	 * @return the strength of the character
	 */
	public int getStrength() {
		return strength;
	}

	/** 
	 * Add to the strength of the character
	 * @param strength The amount of strength to add
	 */
	public void addStrength(int strength) {
		if (this.strength+strength<0){
			this.strength=0;
		}
		else{
			this.strength += strength;
		}
	}

	/** 
	 * Return the room in which the character is
	 * @return the room
	 */
	public Room getActualRoom() {
		return currentRoom;
	}

	/** 
	 * Move the character to a new room
	 * @param actualRoom the new room 
	 */
	public void setActualRoom(Room actualRoom) {
		this.currentRoom = actualRoom;
	}

	/**
	 *  The amount of gold the character has
	 * @return the amount of gold the character has
	 */
	public int getGold() {
		return gold;
	}

	/**
	 *  Add an amount of gold for the character
	 * @param gold the amount of gold to add
	 */
	public void addGold(int gold) {
		if (this.gold+gold<0){
			this.gold=0;
		}
		else{
			this.gold += gold;
		}
	}
	
	/**
	 *  The name of the character
	 * @return the character's name
	 */
	public String getName() {
		return name;
	}

	/**
	 *  Change the character's name
	 * @param name the new name of the character
	 */
	public void setName(String name) {
		this.name = name;
	}


	/**
	 *  The Character attack an other Character c
	 * @param c The Character attacked
	 */
	public void attack(Character c) {
		if (this.strength>=c.getLife()) {
			c.die();
		}
		else {
			c.addLife(-this.strength);
		}
	}
	
	/**
	 *  To know if the character is dead
	 * @return True if the character is dead,else False
	 */
	public boolean isDead() {
		return this.life<=0;
	}

	/**
	 *  Kill the character
	 */
	public abstract void die();
	
	/**
	 *  Character's description
	 * @return the string of description
	 */
	public String getDescription() {
	String stringClass = this.getClass().toString();
	return stringClass.substring(stringClass.lastIndexOf(".")+1)+" "+this.name+" with "+this.life+" life "+this.strength+" strength and "+this.gold+" gold.";
	}
	
	public String toString() {
		return this.name;
	}
		@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((currentRoom == null) ? 0 : currentRoom.hashCode());
		result = prime * result + gold;
		result = prime * result + life;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + strength;
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
		Character other = (Character) obj;
		if (currentRoom == null) {
			if (other.currentRoom != null)
				return false;
		} else if (!currentRoom.equals(other.currentRoom))
			return false;
		if (gold != other.gold)
			return false;
		if (life != other.life)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (strength != other.strength)
			return false;
		return true;
	}
}
