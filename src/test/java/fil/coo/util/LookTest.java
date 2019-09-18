package fil.coo.util;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LookTest {

	private Room r;
	private Player p;
	private Look look;
	
	@Before
	public void setUpBefore() {
		look = new Look();
		r = new Room();
		p = new Player(r,"Morty");
	}
	
	@Test
	public void testIsPossible() {
		assertTrue(look.isPossible(p));
	}

}
