package fil.coo.util;

/** 
 * <b> Class that represent a Monster </b>
 * 
 * <p> When the Monster die he drop all his Gold </p>
 * 
 * @see Character
 * 
 * @author legrand,santi
 *
 */
public class Monster extends Character implements Chooseable{
	
	public Monster(Room r,String name,int life,int strength,int gold) {
		super(r,name,life,strength,gold);
		r.addMonster(this);
	}
	
	public Monster(Room r,String name) {
		super(r,name, 1,1,0);
		r.addMonster(this);
	}
	

	public void die() {
		this.life=0;
		if(this.gold>0) {
			Gold purse = new Gold(this.gold);
			this.currentRoom.addItems(purse);
		}
		this.currentRoom.removeMonster(this);
		this.currentRoom=null;
	}
		

}
