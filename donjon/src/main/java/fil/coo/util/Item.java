package fil.coo.util;

/**
 * <b> Interface that represent an Item </b>
 * 
 * <p> An Item can be used by a Player </p>
 * 
 * @see Player
 * 
 * @author legrand,santi
 *
 */
public interface Item extends Chooseable {
	
	/** 
	 * The item take effect on the Player p
	 * @param p the Player
	 */
	public void isUsedBy(Player p);
	
	/**
	 *  The item's description
	 * @return the String description
	 */
	public String getDescription();
	
}
