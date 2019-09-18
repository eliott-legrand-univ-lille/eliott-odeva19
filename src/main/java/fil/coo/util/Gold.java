package fil.coo.util;

/**
 * <b> Class that represent Gold </b>
 *  
 * <p> Gold is defined by the amount of Gold </p>
 * 
 * @see Item
 * 
 * @author legrand,santi
 *
 */
public class Gold implements Item {

	protected int gold;
	
	public Gold(int gold){
		this.gold=gold;
	}
	
	/**
	 *  The purse's gold amount
	 * @return the amount of gold
	 */
	public int getAmountOfGold() {
		return gold;
	}

	public void isUsedBy(Player p) {
		p.addGold(this.gold);
		p.currentRoom.removeItems(this);
	}
	
	public String toString() {
		String stringClass = this.getClass().toString();
		return stringClass.substring(stringClass.lastIndexOf(".")+1);
		}
	
	public String getDescription() {
		return this.gold+" Gold ";
	}
		
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + gold;
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
		Gold other = (Gold) obj;
		if (gold != other.gold)
			return false;
		return true;
	}	
}
