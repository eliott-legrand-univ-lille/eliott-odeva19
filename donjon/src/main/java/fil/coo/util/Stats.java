package fil.coo.util;


/**
 *  <b> Class that represent the Stats </b>
 *  
 *  <p> Have the Player Stats is always possible, when the Player want to know his
 *  Stats they are displayed </p>
 *  
 *  @see Action
 *  
 * @author legrand,santi
 *
 */
public class Stats extends Action {

	@Override
	public boolean isPossible(Player p) {
		return true;
	}

	@Override
	public void execute(Player p) {
		System.out.println("You are "+p.getDescription());

	}

}
