package fil.coo.util;

import static org.junit.Assert.*;

import org.junit.Test;

public class DirectionTest {

	@Test
	public void testGetOpposite() {
		assertEquals(Direction.NORTH.getOpposite(),Direction.SOUTH);
		assertEquals(Direction.SOUTH.getOpposite(),Direction.NORTH);
		assertEquals(Direction.EAST.getOpposite(),Direction.WEST);
		assertEquals(Direction.WEST.getOpposite(),Direction.EAST);
	}

}
