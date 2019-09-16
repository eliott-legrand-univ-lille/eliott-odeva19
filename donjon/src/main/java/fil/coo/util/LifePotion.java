package fil.coo.util;

/**
 * <b> Class that represent a Life Potion </b>
 * 
 * <p>A Life Potion is defined by the amount of life it can give to a Player </p>
 * 
 * @see Item
 * 
 * @author legrand,santi
 *
 */
public class LifePotion implements Item {

	protected int life;
	
	public LifePotion(int life){
		this.life=life;
	}
	
	/** 
	 * The life this potion give
	 * @return the life the potion give
	 */
	public int getlife() {
		return life;
	}

	public void isUsedBy(Player p) {
		p.addLife(this.life);
		p.currentRoom.removeItems(this);
	}
	
	//On a choisis de ne pas mettre juste return "LifePotion"; si jamais on change
	// le nom de la classe
	public String toString() {
		String stringClass = this.getClass().toString();
		return stringClass.substring(stringClass.lastIndexOf(".")+1);
		}
	
	public String getDescription() {
		return "+"+this.life+" LifePotion";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + life;
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
		LifePotion other = (LifePotion) obj;
		if (life != other.life)
			return false;
		return true;
	}

}
