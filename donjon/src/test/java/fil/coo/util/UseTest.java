package fil.coo.util;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;

import org.junit.Before;
import org.junit.Test;

public class UseTest {

	private Room r;
	private Player p;
	private Gold purse;
	private Use use;
	
	@Before
	public void setUpBefore() {
		use = new Use();
		r = new Room();
		p = new Player(r,"Morty");
		purse = new Gold(10);
	}
	
	@Test
	public void testIsPossible() {
		assertFalse(use.isPossible(p));
		r.addItems(purse);
		assertTrue(use.isPossible(p));
	}

	@Test
	public void testExecute() {
		ByteArrayInputStream data = new ByteArrayInputStream("0\n1\n".getBytes());
		System.setIn(data);
		r.addItems(purse);
		use.execute(p);
		assertSame(0,p.getGold());
		use.execute(p);
		assertSame(10,p.getGold());
		System.setIn(System.in);
	}

}
