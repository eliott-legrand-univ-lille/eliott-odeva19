package fil.coo.util;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GoldTest {

	private Gold purse;
	private Room r;
	private Player p;
	
	@Before
	public void setUpBefore(){
		purse = new Gold(10);
		r = new Room();
		p = new Player(r,"Morty");
	}
	
	@Test
	public void testGoldAndGetAmountOfGold() {
		assertSame(purse.getAmountOfGold(),10);
	}

	@Test
	public void testIsUsedBy() {
		r.addItems(purse);
		purse.isUsedBy(p);
		assertSame(10,p.getGold());
		assertTrue(r.getItems().isEmpty());
	}

}
