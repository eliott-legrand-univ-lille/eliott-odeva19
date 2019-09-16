package fil.coo.util;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;

import org.junit.Before;
import org.junit.Test;

public class FightTest {

	private Room r;
	private Player p;
	private Fight fight;
	private Monster m;
	
	@Before
	public void setUpBefore() {
		r = new Room();
		p = new Player(r,"Morty");
		fight = new Fight();
	}
	
	@Test
	public void testIsPossible() {
		assertFalse(fight.isPossible(p));
		m = new Monster(r,"Figatelli");
		assertTrue(fight.isPossible(p));
	}

	@Test
	public void testExecute() {
		m = new Monster(r,"Figatelli");
		m.addLife(1);
		p.addLife(3);
		fight.execute(p);
		assertSame(p.getLife(),3);
		assertSame(m.getLife(),1);
		fight.execute(p);
		assertSame(p.getLife(),3);
		assertTrue(m.isDead());
	}

}
