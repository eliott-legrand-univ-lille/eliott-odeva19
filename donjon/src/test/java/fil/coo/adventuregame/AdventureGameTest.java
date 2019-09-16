package fil.coo.adventuregame;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import fil.coo.adventuregame.*;
import fil.coo.util.*;

public class AdventureGameTest {

	private Player p;
	private Room r1;
	private Room r2;
	private Monster m;
	private AdventureGame game;
	private AdventureGame game2;
	
	@Before
	public void setUpBefore() {
		r1=new Room();
		r2=new Room(true);
		p=new Player(r1,"Morty", 10, 10, 10);
		m=new Monster(r1,"Rick", 5, 5, 10);
		r1.addNeighboors(Direction.NORTH, r2);
		game=new AdventureGame(r1);
		game2=new AdventureGame(r2);
		game2.play(p);
	}
	
	@Test
	public void testAdventureGameAndCurrentRoom() {
		assertEquals(game.currentRoom(),r1);
	}

	@Test
	public void testGetPlayer() {
		assertEquals(game2.getPlayer(),p);
	}

	@Test
	public void testAddMonster() {
		game.addMonster(m, r1);
		assertEquals(r1.getMonsters().get(0),m);
	}

	@Test
	public void testAddItem() {
		Item i = new Gold(10);
		game.addItem(i,r1);
		assertEquals(r1.getItems().get(0),i);	
	}

	@Test
	public void testIsFinished() {
		AdventureGame game2;
		game2=new AdventureGame(r2);
		assertTrue(game2.isFinished());
		game2.addMonster(m, r2);
		assertFalse(game2.isFinished());
		assertFalse(game.isFinished());
	}
	
	@Test
	public void GameOver(){
		assertFalse(game2.GameOver());
		p.die();
		assertTrue(game2.GameOver());
		
	}

}
