package fil.coo.util;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;

public class MonsterTest extends CharacterTest {
	
	protected Room r1;
	protected Monster m;
	
	@Override
	public Character createCharacter(Room r,String name){
		return new Monster(r,name);
	}
	
	@Before
	public void setUpBefore(){
		this.r1=new Room();
		this.m=new Monster(r1,"Morty");
	}

	@Test
	public void testDie() {
		Player p = new Player(r1,"Rick");
		Monster m1 = new Monster(r1,"Pickle");
		m.addGold(10);
		p.attack(m1);
		assertTrue(m1.isDead());
		assertFalse(r1.getMonsters().contains(m1));
		assertTrue(r1.getItems().isEmpty());
		p.attack(m);
		assertTrue(m.isDead());
		Gold purse = (Gold) r1.getItems().get(0);
		assertSame(purse.getAmountOfGold(),10);
		assertFalse(r1.getMonsters().contains(m));
		assertTrue(r1.getMonsters().isEmpty());
	}



}
