package fil.coo.util;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;

import org.junit.Before;
import org.junit.Test;

public class PlayerTest extends CharacterTest {

	protected Room r1;
	protected Player p;
	protected Action a;
	
	@Override
	public Character createCharacter(Room r,String name){
		return new Player(r,name);
	}
	
	@Before
	public void setUpBefore(){
		this.r1=new Room();
		this.p=new Player(r1,"Morty");
	}
	
	@Test
	public void testDieAndIsDie() {
		assertFalse(this.p.isDead());
		this.p.die();
		assertTrue(this.p.isDead());
	}
	
}
