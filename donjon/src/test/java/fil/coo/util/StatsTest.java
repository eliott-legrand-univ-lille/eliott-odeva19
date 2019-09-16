package fil.coo.util;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class StatsTest {

	private Room r;
	private Player p;
	private Stats stats;
	
	@Before
	public void setUpBefore() {
		stats = new Stats();
		r = new Room();
		p = new Player(r,"Morty");
	}
	
	@Test
	public void testIsPossible() {
		assertTrue(stats.isPossible(p));
	}

}
