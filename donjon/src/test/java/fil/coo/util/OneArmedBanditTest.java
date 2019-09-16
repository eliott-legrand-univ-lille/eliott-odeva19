package fil.coo.util;

import static org.junit.Assert.*;

import org.junit.Test;

public class OneArmedBanditTest {

	@Test
	public void testIsUsedBy() {
		Room r1=new Room();
		Player player1 = new Player(r1,"Un",10,10,0);
		Player player2 = new Player(r1,"Un",10,10,0);
		
		OneArmedBandit bandit = new OneArmedBandit(100);
		assertEquals(player1,player2);
		bandit.isUsedBy(player1);
		assertEquals(player1,player2);
		player1.addGold(100);
		bandit.isUsedBy(player1);
		System.out.println(player1.getDescription());
		System.out.println(player2.getDescription());
		assertNotEquals(player1,player2);
		assertTrue(player1.getGold()<100);
	}

}
