package fil.coo.util;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public abstract class CharacterTest {
	
	protected Character c;
	protected Room r1;
	public abstract Character createCharacter(Room r, String name);

	@Before 
	public void initCharacter(){
		r1=new Room();
		this.c=this.createCharacter(this.r1,"Rick");
	}
	
	@Test
	public void testGetLifeAndAddLife() {
		c.addLife(10);
		assertSame(11,c.getLife());
		c.addLife(-12);
		assertSame(0,c.getLife());
	}

	@Test
	public void testGetStrengthAndAddStrength() {
		c.addStrength(10);
		assertSame(11,c.getStrength());
	}

	@Test
	public void testAddNegativeStrength() {
		c.addStrength(-10);
		assertSame(0,c.getStrength());
	}

	@Test
	public void testGetActualRoomAndGetActualRoom() {
		c.setActualRoom(this.r1);
		assertEquals(c.getActualRoom(),r1);
	}

	@Test
	public void testGetGoldAndAddGold() {
		c.addGold(10);
		assertSame(10,c.getGold());
	}

	@Test
	public void testAddNegativeGold() {
		c.addGold(-10);
		assertSame(0,c.getGold());
	}

	@Test
	public void testGetNameAndSetName() {
		c.setName("Morty");
		assertEquals(c.getName(),"Morty");
	}

	@Test
	public void testIsDead() {
		assertFalse(c.isDead());
		c.addLife(-1);
		assertTrue(c.isDead());
	}

	@Test
	public void testAttack() {
		Character c2=this.createCharacter(this.r1,"Morty");
		c2.addLife(2);
		c.attack(c2);
		assertSame(2,c2.getLife());
		c.attack(c2);
		c.attack(c2);
		assertTrue(c2.isDead());
	}
}