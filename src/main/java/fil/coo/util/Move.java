package fil.coo.util;

import java.util.ArrayList;
import java.util.List;

/**
 *  <b> Class that represent a Move </b>
 *  
 *  <p> Moving is possible when there are no monster alive in the room, the Player
 *  choose a Direction to go </p>
 *  
 *  @see Action
 *  
 * @author legrand,santi
 *
 */
public class Move extends Action {

	@Override
	public boolean isPossible(Player p) {
		List<Monster> monsters;
		monsters = p.getActualRoom().getMonsters();
		if(monsters.isEmpty()) {
			return true;
		}
		return false;
	}

	@Override
	public void execute(Player p) {
		Menu m = new Menu();
		Direction directionChoosen;
		List<Direction> directions = new ArrayList<Direction>(p.getActualRoom().getPossibleDirection());
		if (directions.size()>1){
			directionChoosen=m.choose("Choose a direction", directions );
		}
		else{
			directionChoosen=directions.get(0);
		}
		if (directionChoosen!=null) {
			p.setActualRoom(p.getActualRoom().getNeighboor(directionChoosen));
		}
	}
	
	public static void main(String[] args) {
		Move f = new Move();
		System.out.println(f.toString());
	}

}
