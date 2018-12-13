/**
 * 
 */
package de.jescode.games.ropasci.logic.entity;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author jescode
 *
 */
public class PlayerTest {
	
	private Player player;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		player = new Player();
		player.setStrategy(Strategy.PAPER);
	}

	/**
	 * Test method for {@link de.jescode.games.ropasci.logic.entity.Player#getMove()}.
	 */
	@Test
	public final void testGetMove() {
		assertEquals(Strategy.PAPER, player.getMove());
	}

}
