package fil.coo.util;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LifePotionTest {

	private LifePotion lp;
	private Room r;
	private Player p;
	
	@Before
	public void setUpBefore(){
		lp = new LifePotion(10);
		r = new Room();
		p = new Player(r,"Morty");
	}
	
	@Test
	public void testLifeAndGetLife() {
		assertSame(lp.getlife(),10);
	}

	@Test
	public void testIsUsedBy() {
		r.addItems(lp);
		lp.isUsedBy(p);
		assertSame(11,p.getLife());
		assertTrue(r.getItems().isEmpty());
	}

	
	
}
