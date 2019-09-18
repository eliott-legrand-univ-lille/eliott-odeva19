package fil.coo.util;


import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

@SuppressWarnings("unused")
public class MoveTest {

	private Room r1,r2;
	private Player p;
	private Move mv;
	private Monster m;
	
	@Before
	public void setUpBefore() {
		r1 = new Room();
		r2 = new Room();
		p = new Player(r1,"Morty");
		mv = new Move();
		m = new Monster(r1,"Figatelli");
		r1.addNeighboors(Direction.EAST, r2);
	}
	
	@Test
	public void testIsPossible() {
		assertFalse(mv.isPossible(p));
		m.die();
		assertTrue(r1.getMonsters().isEmpty());
		assertTrue(mv.isPossible(p));
		
	}

	@Test
	public void testExecute() {
		System.setIn(new ByteArrayInputStream("1".getBytes()));
		Move move = new Move();
		r1.addNeighboors(Direction.EAST,r2);
		p.setActualRoom(r1);
		move.execute(p);
		assertEquals(p.getActualRoom(),r2);
	}

}
