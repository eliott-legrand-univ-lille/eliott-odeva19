package fil.coo.util;

import java.util.*;

/** 
 * <b> Class that represent a Player </b>
 * 
 * <p> The Player can proceed an act </p>
 * 
 * @see Character
 * 
 * @author legrand,santi
 *
 */
public class Player extends Character {
	
	protected List<Action> actions;
	
	public Player(Room r,String name,int life,int strength,int gold) {
		super(r,name,life,strength,gold);
		this.actions = new ArrayList<Action>();
	
	}
	
	public Player(Room r,String name) {
		super(r,name,1,1,0);
		this.actions = new ArrayList<Action>();
	}
	
	public void die() {
		this.life=0;
	}
	
	/**
	 * Allow you to choose an action from the action possible
	 */
	public void act() {
		Menu m = new Menu();
		Action actionChoosen;
		this.getPossibleActions();
		actionChoosen=m.choose("Choose an action", this.actions);
		if (actionChoosen!=null){
			actionChoosen.execute(this);
		}
	}
	
	public void getPossibleActions() {
		List<Action> list=new ArrayList<Action>();
		list.add(new Move());
		list.add(new Fight());
		list.add(new Use());
		list.add(new Look());
		list.add(new Stats());
		this.actions.clear();
		for (Action a : list) {
			if (a.isPossible(this)) {
				this.actions.add(a);
			}
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((actions == null) ? 0 : actions.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Player other = (Player) obj;
		if (actions == null) {
			if (other.actions != null)
				return false;
		} else if (!actions.equals(other.actions))
			return false;
		return true;
	}

	public static void main(String[] args) {
		Room r1 = new Room();
		Room r2 = new Room();
		Player p = new Player (r1,"Luc");
		Monster m = new Monster(r2,"Leïla");
		Gold purse = new Gold(10);
		LifePotion lifePotion = new LifePotion(10);
		
		m.addGold(100);
		r1.addNeighboors(Direction.SOUTH, r2);
		r1.addItems(purse);
		p.act();
		p.act();
		r2.addItems(lifePotion);
		p.act();
		p.act();
	}
}
