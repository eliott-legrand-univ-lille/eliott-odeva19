package fil.coo.util;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class StrengthPotionTest {

	private StrengthPotion sp;
	private Room r;
	private Player p;
	
	@Before
	public void setUpBefore(){
		sp = new StrengthPotion(10);
		r = new Room();
		p = new Player(r,"Morty");
	}
	
	@Test
	public void testStrengthAndGetStrength() {
		assertSame(sp.getStrength(),10);
	}

	@Test
	public void testIsUsedBy() {
		r.addItems(sp);
		sp.isUsedBy(p);
		assertSame(11,p.getStrength());
		assertTrue(r.getItems().isEmpty());
	}

}
