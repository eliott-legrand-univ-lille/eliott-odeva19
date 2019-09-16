package fil.coo.util;

/**
 * <b> Class that represent a Strength Potion </b>
 * 
 * <p>A Strength Potion is defined by the amount of strength it can give to a Player </p>
 * 
 * @see Item
 * 
 * @author legrand,santi
 *
 */
public class StrengthPotion implements Item {

	protected int strength;
	
	public StrengthPotion(int strength){
		this.strength=strength;
	}
	
	/** The strength this potion give
	 * @return the strength the potion give
	 */
	public int getStrength() {
		return strength;
	}

	public void isUsedBy(Player p) {
		p.addStrength(this.strength);
		p.currentRoom.removeItems(this);
	}
	
	public String toString() {
		String stringClass = this.getClass().toString();
		return stringClass.substring(stringClass.lastIndexOf(".")+1);
		}
	
	public String getDescription() {
		return "+"+this.strength+" StrengthPotion";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		StrengthPotion other = (StrengthPotion) obj;
		if (strength != other.strength)
			return false;
		return true;
	}

}
