package fil.coo.util;

import java.util.Random;


/**
 * <b>Class that represent a OneArmedBandit</b>
 * 
 * <p>A OneArmedBandit allow you to use an random object in exchange of a certain amount of gold</p>
 * 
 * @see Item
 * 
 * @author legrand,santi
 *
 */
public class OneArmedBandit implements Item {
	private Item i;
	private int cost;
	
	public OneArmedBandit(int cost){
		this.cost = cost;
		Random rand = new Random();
		int r = rand.nextInt(3);
		if (r==0) this.i = new StrengthPotion(rand.nextInt(4)+2);
		else if (r==1) this.i = new LifePotion(rand.nextInt(21)+10);
		else this.i = new Gold(rand.nextInt(51));
	}
	
	public String getDescription() {
		return "One armed bandit that give you an item in exange of "+this.cost+" gold.";
	}
	
	public void isUsedBy(Player player){
		if(player.getGold()>=this.cost){
			player.addGold(-this.cost);
			i.isUsedBy(player);
			player.getActualRoom().removeItems(this);
		}
	}
	
	public String toString() {
		String stringClass = this.getClass().toString();
		return stringClass.substring(stringClass.lastIndexOf(".")+1);
	}

}
