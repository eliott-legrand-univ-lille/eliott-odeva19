package fil.coo.util;


/**
 *  <b> Class that represent a Look </b>
 *  
 *  <p> Take a Look is always possible, when the Player take a Look a description
 *  of his current Room is given </p>
 *  
 *  @see Action
 *  
 * @author legrand,santi
 *
 */
public class Look extends Action {

	@Override
	public boolean isPossible(Player p) {
		return true;
	}

	@Override
	public void execute(Player p) {
		System.out.println(p.getActualRoom().getDescription());
	}

}
