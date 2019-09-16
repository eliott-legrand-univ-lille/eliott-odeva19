package fil.coo.util;

/**
 *  <b>Abstract class that represent an Action</b>
 *  
 *  <p> You can see if the Action is possible for a Player and you can 
 *  execute the Action on him </p>
 *  
 * @see Player 
 *  
 * @author legrand,santi
 *
 */
public abstract class Action implements Chooseable{
	
	/** 
	 * Say if the action is possible for the player p
	 * @param p the player 
	 * @return True is the action is possible for the player p ,else False
	 */
	public abstract boolean isPossible(Player p);
	
	/** 
	 * Execute the action on the Player p
	 * @param p the Player on whom the action is executed
	 */
	public abstract void execute(Player p);
	
	public String toString() {
		String stringClass = this.getClass().toString();
		return stringClass.substring(stringClass.lastIndexOf(".")+1);
		}

}
