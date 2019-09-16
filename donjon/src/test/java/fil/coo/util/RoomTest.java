package fil.coo.util;

import static org.junit.Assert.*;

import org.junit.Test;

public class RoomTest {

	private Room r1 = new Room(true);
	private Room r2 = new Room();
	
	@Test
	public void testRoomAndIsExit() {
		assertFalse(r2.isExit());
		assertTrue(r1.isExit());
	}

	@Test
	public void testAddMonsterAndGetMonsters() {
		Monster m = new Monster(r2,"m");
		r1.addMonster(m);
		assertEquals(r1.getMonsters().get(0),m);
		assertEquals(m.getActualRoom(),r1);
	}

	@Test
	public void test() {
		Monster m = new Monster(r2,"m");
		r1.addMonster(m);
		r1.removeMonster(m);
		assertTrue(r1.getMonsters().isEmpty());
	}

	@Test
	public void testAddNeighboorsAndGetNeighboor() {
		Direction d = Direction.NORTH;
		Direction d2 = Direction.SOUTH;
		Room r3 = new Room();
		r1.addNeighboors(d, r2);
		assertEquals(r1.getNeighboor(d),r2);
		r1.addNeighboors(d, r3);
		assertEquals(r1.getNeighboor(d),r3);
		assertEquals(r3.getNeighboor(d2),r1);
	}

	@Test
	public void testGetPossibleDirection() {
		Direction d = Direction.NORTH;
		r1.addNeighboors(d, r2);
		assertTrue(r1.getPossibleDirection().contains(d));
	}
	
	@Test
	public void getItemsAddItemAndRemoveItem(){
		Item purse= new Gold(10);
		r1.addItems(purse);
		assertEquals(r1.getItems().get(0),purse);
		r1.removeItems(purse);
		assertTrue(r1.getItems().isEmpty());
	}
}
