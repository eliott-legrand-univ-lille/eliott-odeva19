package fil.coo.util;

import java.util.List;
import java.util.ListIterator;

import fil.coo.scanner.*;

/**
 * <b> Class that represent a Menu </b>
 * 
 * <p> The user can choose among a List of Chooseable Object </p>
 * 
 * @author legrand,santi
 *
 */
public class Menu {
	
	/**
	 * For the user can choose among a List
	 * @param msg The message the menu will display
	 * @param list A list of Chooseable Object
	 * @param <T> the type of chooseable object
	 * @return The Object choosen
	 */
	public <T extends Chooseable> T choose(String msg,List<T> list) {
		int cpt,choice;
		cpt=1;
		if (list.isEmpty()) {
			return null;
		}
		System.out.println("\n"+msg+"\n"+"0 None");
		for (ListIterator<T> i = list.listIterator();i.hasNext();) {
			T item = i.next();
			System.out.println((cpt++)+" "+item);
		}
		choice = ScannerInt.readInt(list.size()+1);
		if (choice==0) {
			return null;
		}
		return list.get(choice-1);
	}
}
