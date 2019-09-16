package fil.coo.util;


/**
 *  <b> Class that represent Using </b>
 *  
 *  <p> Using an item is possible when there are items in the room, the Player choose an Item to use </p>
 *  
 * @see Action
 *  
 * @author legrand,santi
 *
 */
public class Use extends Action {
	
	@Override
	public boolean isPossible(Player p) {
		return !p.getActualRoom().getItems().isEmpty();
	}

	@Override
	public void execute(Player p) {
		Menu m = new Menu();
		Item item = m.choose("Choose an item to use", p.getActualRoom().getItems());
		if (item!=null) {
			item.isUsedBy(p);
		}
	}

}
